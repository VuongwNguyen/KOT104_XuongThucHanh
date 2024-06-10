package com.example.kot104_xuongthuchanh.components.screens.main.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.components.customCpns.ButtonIconCustom
import com.example.kot104_xuongthuchanh.helper.RetrofitAPI
import com.example.kot104_xuongthuchanh.httpModel.categories.CategoryResponse
import com.example.kot104_xuongthuchanh.httpModel.categories.dataCategory
import com.example.kot104_xuongthuchanh.httpModel.categories.dataCategoryResponse
import com.example.kot104_xuongthuchanh.httpModel.categories.dataProducts
import com.example.kot104_xuongthuchanh.models.UserInfo

//trihmps36557

@Composable
fun HomeScreen(navControllerContainer: NavHostController, writeToShared: (UserInfo) -> Unit) {

    var Categories = remember { mutableStateListOf<dataCategoryResponse>() }

    fun callBackcategory(response: CategoryResponse) {
        Categories.clear()
        Categories.addAll(response.data ?: listOf())
    }

    fun getAllCategories() {
        try {
            val api = RetrofitAPI()
            api.getCategories {
                if (it != null) {
                    callBackcategory(it)
                }
            }
        } catch (e: Exception) {
            println("${e.message}")
        }
    }

    getAllCategories()

    Surface (
        color = Color(android.graphics.Color.parseColor("#263238"))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ButtonIconCustom(
                    icon = R.drawable.menu2,
                    shape = 4,
                    width = 40,
                    height = 40,
                    elevation = 10,
                    onClick = { /*TODO*/ },
                    colorShadow = "ffffff"
                )

                Column(
                    modifier = Modifier
                        .width(210.dp)
                        .align(Alignment.CenterVertically),
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "Deliver to",
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 17.sp,
                        color = Color(android.graphics.Color.parseColor("#8C9099"))
                    )

                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "Choose your city and state",
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 18.sp,
                        color = Color(android.graphics.Color.parseColor("#FE724C"))
                    )
                }

                ButtonIconCustom(
                    icon = R.drawable.personal1,
                    shape = 4,
                    width = 40,
                    height = 40,
                    elevation = 10,
                    onClick = { writeToShared(
                        UserInfo(
                            userId = null,
                            email = null,
                            fullname = null
                        )
                    ) },
                    colorShadow = "ffffff"
                )
            }


            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                Categories.forEach { (category, products) ->
                    item {
                        CategorySection(category = category, items = products, navControllerContainer)
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CategorySection(
    category: dataCategory,
    items: List<dataProducts>,
    navControllerContainer: NavHostController
) {
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${category.name}",
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontSize = 16.sp,
                fontWeight = FontWeight(800),
                lineHeight = 16.sp,
                color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

            TextButton(
                    onClick = { navControllerContainer.navigate("ProductInCategoryScreen/${category.id}") },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "see all",
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 14.sp,
                        color = Color(android.graphics.Color.parseColor("#22A45D"))
                    )
                }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ) {
            items(
                items = items,
                itemContent = { item ->
                    cpnItem(item, navControllerContainer)
                    Spacer(modifier = Modifier.width(15.dp))
                }
            )
        }
    }
}
@Composable
fun cpnItem(item: dataProducts, navControllerContainer: NavHostController) {
    Column(
        modifier = Modifier
            .width(266.dp)
            .height(229.dp)
            .clip(RoundedCornerShape(25.dp))
            .clickable { navControllerContainer.navigate("DetailProductScreen/${item.id}") }
    ){
        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
        ){
            AsyncImage(
                model = item.image_url,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp)
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row (
                        modifier = Modifier
                            .width(80.93.dp)
                            .height(28.07.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color.White)
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "4.5",
                            fontSize = 11.69.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_thinitalic)),
                            color = Color.Black
                        )

                        Image(
                            painter = painterResource(id = R.drawable.icon_start_lab3),
                            contentDescription = null,
                            modifier = Modifier
                                .width(11.6.dp)
                                .height(9.45.dp)
                        )

                        Text(
                            text = "(25+)",
                            fontSize = 11.69.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_thinitalic)),
                            color = Color.Black
                        )
                    }

                    ButtonIconCustom(
                        icon = R.drawable.icon_love,
                        shape = 10,
                        width = 28,
                        height = 28,
                        elevation = 8,
                        onClick = { /*TODO*/ },
                        colorShadow = "ffffff"
                    )
                }
            }
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(vertical = 10.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "${item.name}",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.icon_tick_lab3),
                    contentDescription = null,
                    modifier = Modifier
                        .width(11.dp)
                        .height(11.dp)
                )
            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_shiper_lab3),
                    contentDescription = null,
                    modifier = Modifier
                        .width(16.16.dp)
                        .height(11.43.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "Free delivery",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color(android.graphics.Color.parseColor("#7E8392"))
                )

                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.icon_time_lab3),
                    contentDescription = null,
                    modifier = Modifier
                        .width(12.53.dp)
                        .height(12.09.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "10 - 15 mins",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color(android.graphics.Color.parseColor("#7E8392"))
                )
            }

            Row {
                Text(
                    text = "BURGER",
                    modifier = Modifier
                        .width(63.34.dp)
                        .height(22.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color = Color(android.graphics.Color.parseColor("#F6F6F6"))),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color(android.graphics.Color.parseColor("#8A8E9B"))
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "CHICKEN",
                    modifier = Modifier
                        .width(63.34.dp)
                        .height(22.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color = Color(android.graphics.Color.parseColor("#F6F6F6"))),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color(android.graphics.Color.parseColor("#8A8E9B"))
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "FAST FOOD",
                    modifier = Modifier
                        .width(63.34.dp)
                        .height(22.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color = Color(android.graphics.Color.parseColor("#F6F6F6"))),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color(android.graphics.Color.parseColor("#8A8E9B"))
                )

            }
        }
    }
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(20.dp))
}