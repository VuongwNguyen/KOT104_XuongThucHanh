package com.example.kot104_xuongthuchanh.components.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kot104_xuongthuchanh.R

data class Product(val name:String, val image: Int, val rate:Double)
 val ItemProduct = listOf(
     Product("Ground Beef Tacos",R.drawable.beef_tacos,4.5),
     Product("Ground Beef Tacos",R.drawable.beef_tacos,4.5),
     Product("Ground Beef Tacos",R.drawable.beef_tacos,4.5),
 )
@Composable
fun DetailProductScreen(Nav_Controller: NavHostController) {
    Column(
        modifier = Modifier
            .background(color = Color(0xff263238))
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.beef_tacos),
                contentDescription = null,
                modifier = Modifier
                    .height(198.dp)
                    .width(380.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_back_container2),
                    contentDescription = null,
                    modifier = Modifier
                        .height(38.dp)
                        .width(38.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_love_choose),
                    contentDescription = null,
                    modifier = Modifier
                        .height(38.dp)
                        .width(38.dp)
                )
            }
        }
        Text(
            text = "Ground Beef Tacos",
            style = TextStyle(
                color = Color(0xffFF7400),
                fontWeight = FontWeight(500),
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            ),
            modifier = Modifier
                .padding(start = 35.dp)
                .padding(top = 20.dp)
        )
        Row (
            modifier = Modifier
                .padding(start = 35.dp)
                .padding(top = 30.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.icon_sao_feedback),
                contentDescription = null,
                modifier = Modifier
                    .height(17.dp)
                    .width(17.dp)
            )
            Text(
                text = "4,5",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight(500),
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                ),
                modifier = Modifier
                    .padding(start = 7.dp)
            )
            Text(
                text = "(30+)",
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight(500),
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                ),
                modifier = Modifier
                    .padding(start = 7.dp)
            )

            Row(
                modifier = Modifier
                    .padding(start = 30.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_shiper_lab3),
                    contentDescription = null,
                    modifier = Modifier
                        .height(17.dp)
                        .width(17.dp)
                )
                Text(
                    text = "Free delivery",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    ),
                    modifier = Modifier
                        .padding(start = 10.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_time_lab3),
                    contentDescription = null,
                    modifier = Modifier
                        .height(17.dp)
                        .width(17.dp)
                        .padding(start = 5.dp)
                )
                Text(
                    text = "10-15 mins",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    ),
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 35.dp)
                .padding(top = 40.dp)
        ){
            Text(
                text = "9.35$",
                style = TextStyle(
                    color = Color(0xff22A45D),
                    fontWeight = FontWeight(500),
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                ),
            )
        }

        Text(
            text = "Brown the beef better. Lean ground beef – I like to use 85% lean angus. Garlic – use fresh  chopped. Spices – chili powder, cumin, onion powder.",
            style = TextStyle(
                color = Color(0xffC0C0C0),
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular  )),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp)
                .padding(top = 30.dp)
        )


        Row(){
            Text(
                text = "Restaurant’ss Featured Partner ",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight(500),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                ),
                modifier = Modifier
                    .padding(start = 35.dp)
                    .padding(top = 20.dp)
            )
            Text(
                text = "see all",
                style = TextStyle(
                    color = Color(0xff22A45D),
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                ),
                modifier = Modifier
                    .padding(start = 35.dp)
                    .padding(top = 20.dp)
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 30.dp)

        ){
            items(ItemProduct){ item ->
                ListProduct(item)
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 35.dp)
                .padding(top = 20.dp)
        ){
            TextButton(
                modifier = Modifier
                    .width(250.dp)
                    .height(48.dp)
                    .background(
                        color =  Color(0xFFcFF7400),
                        shape = MaterialTheme.shapes.small),
                onClick = {}
            ) {
                Text(
                    text ="Add to cart", color = Color(0xFFcFFFFFF,),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                    )
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_warning), contentDescription=  null,
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)


            )
        }
    }
}


@Composable
fun ListProduct(item: Product){
    Box(

    ) {
        Image(
            painter = painterResource(id = item.image), contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .width(250.dp)
            )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(40.dp)
                    .width(100.dp)
                    .padding(top = 10.dp)
                    .padding(start = 15.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))

            ) {
                Text(
                    text = "${item.rate}",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_thinitalic)),
                    ),
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_sao_feedback),
                    contentDescription = null,
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Text(
                    text = "(30+)",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_thinitalic)),
                    ),
                )
            }
            Image(
                painter = painterResource(id = R.drawable.icon_love), contentDescription=  null,
                modifier = Modifier
                    .height(40.dp)
                    .width(150.dp)
                    .padding(start = 100.dp)
                    .padding(top = 10.dp)
                )
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    KOT104_XuongThucHanhTheme {
////        DetailProductScreen()
//    }
//}