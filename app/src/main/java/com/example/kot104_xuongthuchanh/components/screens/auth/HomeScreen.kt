package com.example.kot104_xuongthuchanh.components.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.components.customCpns.ButtonIconCustom

//trihmps36557
data class product(
    val id: Int,
    val name: String,
    val start: Float,
    val vote:  Int,
    val img: String,
    val category: String,
)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {

    val products = listOf(
        product(1, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì heo"),
        product(2, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì heo"),
        product(3, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì heo"),
        product(4, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì heo"),
        product(5, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì heo"),
        product(6, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì bò"),
        product(7, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì bò"),
        product(8, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì bò"),
        product(9, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì bò"),
        product(10, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì bò"),
        product(11, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì trứng"),
        product(12, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì trứng"),
        product(13, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì trứng"),
        product(14, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì trứng"),
        product(15, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg", "Bánh mì trứng"),
    )

    val groupedProducts = products.groupBy { it.category }

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
                    onClick = { /*TODO*/ },
                    colorShadow = "ffffff"
                )
            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 10.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = "",
//                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight(800),
//                    lineHeight = 16.sp,
//                    color = Color(android.graphics.Color.parseColor("#FFFFFF"))
//                )
//
//                TextButton(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier
//                        .align(Alignment.CenterVertically)
//                ) {
//                    Text(
//                        text = "see all",
//                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight(400),
//                        lineHeight = 14.sp,
//                        color = Color(android.graphics.Color.parseColor("#22A45D"))
//                    )
//                }
//            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                groupedProducts.forEach { (category, items) ->
                    item {
                        CategorySection(category = category, items = items)
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CategorySection(category: String, items: List<product>) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = category,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontSize = 16.sp,
                fontWeight = FontWeight(800),
                lineHeight = 16.sp,
                color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

            TextButton(
                    onClick = { /*TODO*/ },
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
                    cpnItem(item)
                    Spacer(modifier = Modifier.width(15.dp))
                }
            )
        }
    }
}
@Composable
fun cpnItem(item: product) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(item.img)
            .size(Size.ORIGINAL)
            .build()
    )
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(229.dp)
            .clip(RoundedCornerShape(25.dp))
    ){
        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
        ){
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
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
                            text = "${item.start}",
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
                            text = "(${item.vote}+)",
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