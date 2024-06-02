package com.example.kot104_xuongthuchanh.components.customCpns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ButtonIconCustom(
    icon: Int,
    shape: Int,
    width: Int,
    height: Int,
    elevation: Int,
    onClick: () -> Unit,
    colorShadow: String
){
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        elevation = null,
        contentPadding = PaddingValues(10.dp),
        shape = RoundedCornerShape(shape.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.width(width.dp).height(height.dp)
                .shadow(
                    elevation = elevation.dp,
                    shape = RoundedCornerShape(shape.dp),
                    spotColor = Color(android.graphics.Color.parseColor("#$colorShadow")),
                    ambientColor = Color(android.graphics.Color.parseColor("#$colorShadow")),
                    clip = true
                ),
            contentScale = ContentScale.FillBounds
        )
    }
}