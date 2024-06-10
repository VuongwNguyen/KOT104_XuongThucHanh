package com.example.kot104_xuongthuchanh.components.screens.main.stacks


import android.util.Log
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.components.customCpns.ButtonIconCustom
import com.example.kot104_xuongthuchanh.helper.RetrofitAPI
import com.example.kot104_xuongthuchanh.httpModel.categories.dataProducts
import com.example.kot104_xuongthuchanh.httpModel.products.ProductsByCategoryResponse



@Composable
fun ProductInCategoryScreen(navControllerContainer: NavHostController, categoryId: String?) {
    var Products = remember {
        mutableStateListOf<dataProducts>()
    }

    var nameCategory = remember {
        mutableStateOf("")
    }

    fun callBackProductsByCategory(it: ProductsByCategoryResponse) {
        Products.clear()
        Products.addAll(it.data.products ?: listOf())
        nameCategory.value = it.data.nameCategory.name
    }

    fun getProductsByCategory(){
        try {
            val api = RetrofitAPI()
            if (categoryId != null){
                api.getProductsByCategory(categoryId = categoryId){
                    if (it != null){
                        callBackProductsByCategory(it)
                    }
                }
            }
        }catch (e: Exception){
            Log.d(">>>>", "getProductByCategory: ${e.message}")
        }
    }

    getProductsByCategory()

    Surface (
        color = Color(android.graphics.Color.parseColor("#263238"))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                ButtonIconCustom(
                    icon = R.drawable.icon_back_lab3,
                    shape = 4,
                    width = 38,
                    height = 38,
                    elevation = 10,
                    onClick = { navControllerContainer.popBackStack() },
                    colorShadow = "ffffff"
                )

                Text(
                    text = "${nameCategory.value}",
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    color = Color(android.graphics.Color.parseColor("#FF7400"))
                )

                Spacer(modifier = Modifier
                    .width(38.dp)
                    .height(38.dp))
            }

            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ){
                items(
                    items = Products,
                    itemContent = { item ->
                        cpnItem(item, navControllerContainer)
                    }
                )
            }
        }
    }
}

@Composable
fun cpnItem(item: dataProducts, navControllerContainer: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
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
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize())
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
