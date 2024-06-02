package com.example.demo_app_kotlin.com_tam.components.customCpnsLabs

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_xuongthuchanh.R

@Composable
fun TextHeader(text: String, marginTop: Int) {
    Text(
        text = "$text",
        fontSize = 36.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        maxLines = 2,
        style = TextStyle(
            lineHeight = 34.sp
        ),
        modifier = Modifier.width(200.dp).
        padding(top = marginTop.dp)
    )
}