package com.example.demo_app_kotlin.com_tam.components.customCpnsLabs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_xuongthuchanh.R

@Composable
fun ButtonCustom(textButton: String) {
    Surface(
        modifier = Modifier.padding(top = 20.dp),
        color = Color.Transparent
    ) {
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#FF7400"))
            )
        ) {
            Text(
                text = "$textButton",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold))
            )
        }
    }
}