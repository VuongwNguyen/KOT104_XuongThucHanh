package com.example.kot104_xuongthuchanh.components.screens.auth

import  androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.ButtonCustom
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextHeader
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextHeaderDetail
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextInputCustom
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.ui.theme.ColorBackground


@Composable
fun LoginScreen(Nav_Controller: NavHostController) {
    var Email = remember { mutableStateOf("") }
    var Password = remember { mutableStateOf("") }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBackground)
    ){
        Box (
            modifier = Modifier.zIndex(0f)
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Box {
                    Box (
                        modifier = Modifier
                            .offset(x = (-46.dp), y = (-21.dp))
                            .zIndex(0f)
                    ){
                        Box(
                            modifier = Modifier
                                .size(96.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color(0xffFE724C))
                        ){
                            Box(modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .background(color = ColorBackground)
                                .align(Alignment.Center))
                        }
                    }

                    Box(modifier = Modifier
                        .zIndex(1f)
                        .offset(x = (-5.dp), y = (-99.dp))){
                        Box(modifier = Modifier
                            .size(165.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xffFFECE7)))
                    }
                }
                Box (modifier = Modifier.offset(x = 90.dp,y = (-109.dp))){
                    Box(modifier = Modifier
                        .size(181.dp)
                        .clip(CircleShape)
                        .background(Color(0xffFE724C)))
                }
            }
        }


        Column (
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .zIndex(1f)
                .offset(y = 17.dp)
        ){
            TextHeader(text = "Well hello there !", marginTop = 30)
            TextHeaderDetail(
                text1 = "Enter your Email and Password to login, or ",
                text2 = "Create new account.",
                marginTop = 10,
                maxLine = 2,
                with = 231,
                click = { Nav_Controller.navigate("RegisterScreen") }
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextInputCustom(
                valueChange = Email,
                textPlacehoder = "Email",
                imgRight = R.drawable.email,
                isTextInputPassword = false
            )

            TextInputCustom(
                valueChange = Password,
                textPlacehoder = "Password",
                imgRight = R.drawable.key,
                isTextInputPassword = true
            )

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Forgot Password ?",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Color.Blue,
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center
                )
            }

            ButtonCustom(textButton = "Sign In")
        }
    }
}