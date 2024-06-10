package com.example.demo_app_kotlin.asm.navigation.bottomTab

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kot104_xuongthuchanh.ui.theme.ColorBackground

@Composable
fun ContainerBottomTab(
    Items: List<DataClassItem>,
    navControllerContainer: NavController
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar (
        containerColor = ColorBackground,
    ){
        Items.forEachIndexed { index, dataClassItem ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navControllerContainer.navigate(dataClassItem.route)
                },
                icon = {
                    ItemView(
                        isSelected = selectedItemIndex == index,
                        selectedIcon = dataClassItem.selectedIcon,
                        unSelectedIcon = dataClassItem.unSelectedIcon,
                        route = dataClassItem.route
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorBackground, // Set your desired selected icon color
                    unselectedIconColor = ColorBackground, // Set your desired unselected icon color
                    selectedTextColor = ColorBackground, // Set your desired selected text color
                    unselectedTextColor = ColorBackground, // Set your desired unselected text color
                    indicatorColor = ColorBackground // Set your desired indicator color
                )
            )
        }
    }

}