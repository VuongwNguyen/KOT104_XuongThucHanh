package com.example.demo_app_kotlin.com_tam.components.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.kot104_xuongthuchanh.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GetStartedScreen(Nav_Controller: NavHostController) {
    val listItem = listOf(
        ItemData(
            R.drawable.img_getstarted1,
            "Easy to Order",
            "Experience seamless convenience with our fast and user-friendly food delivery app, making ordering your favorite meals a breeze!"
        ),
        ItemData(
            R.drawable.img_getstarted2,
            "Has the most delicious food",
            "Enjoy dishes expertly prepared by experienced chefs for a wonderful dining experience!"
        ),
        ItemData(
            R.drawable.img_getstarted3,
            "Schedule your own meals",
            "Take charge of your health with scheduled, nutritious meals tailored just for you."
        ),
        ItemData(
            R.drawable.img_getstarted4,
            "What are you waiting for ?",
            "Explore a world of culinary delights – place your order now and discover a variety of tempting dishes waiting just for you!"
        )
    )

    val pagerState = rememberPagerState(pageCount = { listItem.size })
    val screenWidth = with(LocalConfiguration.current) { screenWidthDp.dp }

    Box() {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .zIndex(0f),
        ) { page ->
            ItemStarted(
                img = listItem[page].img,
                detailFooter = listItem[page].detailFooter,
                contentFooter = listItem[page].contentFooter
            )
        }

        Column (
            modifier = Modifier
                .zIndex(1f)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ) {
                repeat(pagerState.pageCount) { index ->
                    val colorChoose =
                        if (pagerState.currentPage == index) Color(0xffFF7400) else Color(0xff979797)

                    Box(
                        modifier = Modifier
                            .width(8.dp)
                            .height(5.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(color = colorChoose)
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

            ElevatedButton(
                onClick = { Nav_Controller.navigate("LoginScreen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffFF7400),
                    disabledContainerColor = Color(0xffFF7400),
                    contentColor = Color(0xffFF7400),
                    disabledContentColor = Color(0xffFF7400),
                )
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            
            Spacer(modifier = Modifier.height(30.dp))
        }
    }

}


data class ItemData(val img: Int, val detailFooter: String, val contentFooter: String)

@Composable
fun ItemStarted(img: Int, detailFooter: String, contentFooter: String) {
    Surface(color = Color(0xff263238)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.White)) {
                            append("Welcome to ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xffFF7400))) {
                            append("Orangic")
                        }
                    },
                    fontSize = 36.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    lineHeight = 34.sp,
                    maxLines = 2,
                    modifier = Modifier.width(177.dp)
                )

                Text(
                    text = "Your favourite foods delivered fast at your door.",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color(0xffC0C0C0),
                    lineHeight = 16.sp,
                    maxLines = 2,
                    modifier = Modifier
                        .width(224.dp)
                        .padding(top = 10.dp, bottom = 20.dp)
                )
            }

            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier.size(312.dp)
            )

            Text(
                text = detailFooter,
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                color = Color.White,
                lineHeight = 20.sp,
                modifier = Modifier.padding(top = 10.dp)
            )

            Text(
                text = contentFooter,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                color = Color(0xffC0C0C0),
                lineHeight = 18.sp,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
