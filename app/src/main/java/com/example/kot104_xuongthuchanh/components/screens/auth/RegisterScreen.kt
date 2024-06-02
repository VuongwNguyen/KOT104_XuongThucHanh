package com.example.demo_app_kotlin.com_tam.components.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.ButtonCustom
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextHeader
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextHeaderDetail
import com.example.demo_app_kotlin.com_tam.components.customCpnsLabs.TextInputCustom
import com.example.kot104_xuongthuchanh.R

@Composable
fun RegisterScreen(Nav_Controller: NavHostController) {
    var name = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    Surface(
        color = Color(android.graphics.Color.parseColor("#263238"))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            TextHeader(text = "Create Account", marginTop = 30)
            TextHeaderDetail(
                text1 = "Enter your Email and Password to sign up. ",
                text2 = "Already have an account?.",
                marginTop = 10,
                maxLine = 2,
                with = 231,
                click = { Nav_Controller.navigate("LoginScreen") }
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_login_lab2),
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                )
            }

            TextInputCustom(
                valueChange = name,
                textPlacehoder = "Your name",
                imgRight = R.drawable.name,
                isTextInputPassword = false
            )

            TextInputCustom(
                valueChange = email,
                textPlacehoder = "Email",
                imgRight = R.drawable.email,
                isTextInputPassword = false
            )

            TextInputCustom(
                valueChange = password,
                textPlacehoder = "Password",
                imgRight = R.drawable.key,
                isTextInputPassword = true
            )

            ButtonCustom(textButton = "SIGN UP")
        }
    }
}








