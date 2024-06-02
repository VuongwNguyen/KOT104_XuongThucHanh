package com.example.demo_app_kotlin.com_tam.components.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.ButtonCustom
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextHeader
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextHeaderDetail
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextInputCustom
import com.example.kot104_xuongthuchanh.R

@Composable
fun EnterAddressScreen(){
    var city = remember { mutableStateOf("") }
    var state = remember { mutableStateOf("") }
    var address = remember { mutableStateOf("") }
    Surface (
        color = Color(android.graphics.Color.parseColor("#263238"))
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.End
            ){
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "Skip",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        color = Color.Black
                    )
                }
            }

            TextHeader(text = "Well done !", marginTop = 20)

            TextHeaderDetail(
                text1 = "Your account is ready, we only need a little bit more informations to help you have a better experience",
                text2 = "",
                marginTop = 20,
                maxLine = 3, with = 249, click = {}
            )

            TextInputCustom(
                valueChange = city,
                textPlacehoder = "Your city",
                imgRight = R.drawable.city,
                isTextInputPassword = false
            )

            TextInputCustom(
                valueChange = state,
                textPlacehoder = "Your state",
                imgRight = R.drawable.state,
                isTextInputPassword = false
            )

            TextInputCustom(
                valueChange = address,
                textPlacehoder = "Your address",
                imgRight = R.drawable.address,
                isTextInputPassword = false
            )

            ButtonCustom(textButton = "Let's go")
        }
    }
}