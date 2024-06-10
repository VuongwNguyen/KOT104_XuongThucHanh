package com.example.demo_app_kotlin.asm.navigation.bottomTab

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.components.screens.main.tabs.CartScreen
import com.example.kot104_xuongthuchanh.components.screens.main.tabs.FavoriteScreen
import com.example.kot104_xuongthuchanh.components.screens.main.tabs.HomeScreen
import com.example.kot104_xuongthuchanh.components.screens.main.tabs.LocationScreen
import com.example.kot104_xuongthuchanh.components.screens.main.tabs.StoteScreen
import com.example.kot104_xuongthuchanh.models.Cart
import com.example.kot104_xuongthuchanh.models.UserInfo

@Composable
fun MainTab(
    navControllerContainer: NavHostController,
    listCart: SnapshotStateList<Cart>,
    changeQuantityCart: (Cart, Number: Int) -> Unit,
    orderCart: () -> Unit,
    deleteItemCart: (Cart) -> Unit,
    writeToShared: (UserInfo) -> Unit,) {
    val listItemsTab = listOf(
        DataClassItem(
            route = "HomeScreen",
            selectedIcon = R.drawable.ic_home_choose,
            unSelectedIcon = R.drawable.home
        ),
        DataClassItem(
            route = "FavoriteScreen",
            selectedIcon = R.drawable.favorite_choose,
            unSelectedIcon = R.drawable.favorite
        ),
        DataClassItem(
            route = "LocationScreen",
            selectedIcon = R.drawable.location_choose,
            unSelectedIcon = R.drawable.location
        ),
        DataClassItem(
            route = "StoreScreen",
            selectedIcon = R.drawable.store_choose,
            unSelectedIcon = R.drawable.store
        ),
        DataClassItem(
            route = "CartScreen",
            selectedIcon = R.drawable.cart_choose,
            unSelectedIcon = R.drawable.cart
        ),
    )

    val Nav_Controller = rememberNavController()
    Scaffold(bottomBar = {
        ContainerBottomTab(
            Items = listItemsTab,
            navControllerContainer = Nav_Controller
        )
    }) { paddingValues ->
        NavHost(navController = Nav_Controller, startDestination = listItemsTab[0].route, modifier = Modifier.padding(paddingValues)) {
            composable(listItemsTab[0].route) { HomeScreen(navControllerContainer, writeToShared) }
            composable(listItemsTab[1].route) { FavoriteScreen(navControllerContainer) }
            composable(listItemsTab[2].route) { LocationScreen(navControllerContainer)}
            composable(listItemsTab[3].route) { StoteScreen(navControllerContainer) }
            composable(listItemsTab[4].route) { CartScreen(navControllerContainer, listCart, changeQuantityCart, orderCart, deleteItemCart) }
        }
    }
}