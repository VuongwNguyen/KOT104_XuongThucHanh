package com.example.demo_app_kotlin.com_tam.components.screens


import android.util.Log
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
import androidx.compose.runtime.MutableState
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
import com.example.kot104_xuongthuchanh.helper.RetrofitAPI
import com.example.kot104_xuongthuchanh.httpModel.auth.RegisterRequest
import com.example.kot104_xuongthuchanh.httpModel.auth.RegisterResponse

@Composable
fun RegisterScreen(
    Nav_Controller: NavHostController,
    isShowBottomSheet: MutableState<Boolean>,
    textContentBottomSheet: MutableState<String>
) {
    var name = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var ConfirmPassword = remember { mutableStateOf("") }
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
                click = { Nav_Controller.popBackStack() }
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

            TextInputCustom(
                valueChange = ConfirmPassword,
                textPlacehoder = "Password",
                imgRight = R.drawable.key,
                isTextInputPassword = true
            )

            ButtonCustom(textButton = "SIGN UP", onClick = {onClickRegister(name, email, password, ConfirmPassword, isShowBottomSheet, textContentBottomSheet, Nav_Controller)})
        }
    }
}

fun onClickRegister(
    name: MutableState<String>,
    email: MutableState<String>,
    password: MutableState<String>,
    ConfirmPassword: MutableState<String>,
    isShowBottomSheet: MutableState<Boolean>,
    textContentBottomSheet: MutableState<String>,
    Nav_Controller: NavHostController,
) {
    try {
        if (name.value.isEmpty() || email.value.isEmpty() || password.value.isEmpty() || ConfirmPassword.value.isEmpty()){
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Vui lòng điền đầy đủ thông tin!"
            return
        }
        if (!isValidEmail(email.value)){
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Email không hợp lệ!"
            return
        }
        if (password.value != ConfirmPassword.value){
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Password và ConfirmPassword không giống nhau!"
            return
        }

        val retrofitAPI = RetrofitAPI()
        val body = RegisterRequest(email = email.value, fullname = name.value, password = password.value)
        retrofitAPI.register(body = body, callback = { callBackRegister(it, Nav_Controller) })
    }catch (e: Exception){
        Log.d("", "onClickRegister: ${e.message}")
    }
}

fun callBackRegister(
    registerResponseModel: RegisterResponse?,
    Nav_Controller: NavHostController,
) {
    if (registerResponseModel?.status == true) {
        Nav_Controller.popBackStack()
    }
}

fun isValidEmail(email: String): Boolean {
    val pattern = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    return pattern.matches(email)
}








