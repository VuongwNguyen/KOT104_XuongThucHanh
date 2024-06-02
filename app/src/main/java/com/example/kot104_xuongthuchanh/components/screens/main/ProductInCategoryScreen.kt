package com.example.kot104_xuongthuchanh.components.screens.main


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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.components.customCpns.ButtonIconCustom

data class productInCategory(
    val id: Int,
    val name: String,
    val start: Float,
    val vote:  Int,
    val img: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductInCategoryScreen(){
    val products = listOf(
        productInCategory(1, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(2, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(3, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(4, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(5, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(6, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(7, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(8, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(9, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(10, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(11, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
        productInCategory(12, "McDonald’s",4.5f,25, "https://cdn.tgdd.vn/Products/Images/42/324893/honor-x8b-thiet-ke.jpg"),
    )

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
                    onClick = { /*TODO*/ },
                    colorShadow = "ffffff"
                )

                Text(
                    text = "Featured Partner",
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
                    items = products,
                    itemContent = { item ->
                        cpnItem(item)
                    }
                )
            }
        }
    }
}

@Composable
fun cpnItem(item: productInCategory) {
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
