package com.example.demo_app_kotlin.asm.navigation.bottomTab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ItemView(
    isSelected: Boolean,
    selectedIcon: Int,
    unSelectedIcon: Int,
    route: String
){
    Image(
        painter = painterResource(id = if (isSelected) selectedIcon else unSelectedIcon),
        contentDescription = null,
        modifier = Modifier.size(24.dp)
    )
}