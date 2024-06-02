package com.example.demo_app_kotlin.com_tam.components.customCpnsLabs


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_xuongthuchanh.R

@Composable
fun TextHeaderDetail(
    text1: String,
    text2: String,
    marginTop: Int,
    maxLine: Int,
    with: Int,
    click: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(android.graphics.Color.parseColor("#C0C0C0")))) {
            append(text1)
        }
        pushStringAnnotation(tag = "CLICKABLE", annotation = "clickable_part")
        withStyle(style = SpanStyle(color = Color(android.graphics.Color.parseColor("#FF7400")))) {
            append(text2)
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            lineHeight = 16.sp
        ),
        modifier = Modifier.width(with.dp).padding(top = marginTop.dp),
        maxLines = maxLine,
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "CLICKABLE", start = offset, end = offset)
                .firstOrNull()?.let {
                    click()
                }
        }
    )
}