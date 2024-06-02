package com.example.demo_app_kotlin.com_tam.components.customCpnsLabs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_xuongthuchanh.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputCustom(
    valueChange: MutableState<String>,
    textPlacehoder: String,
    imgRight: Int,
    isTextInputPassword: Boolean
) {
    Surface(
        modifier = Modifier.padding(top = 20.dp),
        color = Color.Transparent
    ) {
        TextField(
            value = valueChange.value,
            onValueChange = { valueChange.value = it },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                errorContainerColor = Color.White
            ),
            placeholder = {
                Text(
                    text = "$textPlacehoder",
                    color = Color(android.graphics.Color.parseColor("#C0C0C0")),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    lineHeight = 20.sp
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                lineHeight = 20.sp
            ),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = imgRight),
                    contentDescription = null,
                    modifier = Modifier.height(24.dp).width(24.dp)
                )
            },
            visualTransformation = if (isTextInputPassword) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}