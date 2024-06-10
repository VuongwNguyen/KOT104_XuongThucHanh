package com.example.kot104_xuongthuchanh.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demo_app_kotlin.asm.navigation.bottomTab.MainTab
import com.example.demo_app_kotlin.com_tam.components.screens.GetStartedScreen
import com.example.demo_app_kotlin.com_tam.components.screens.RegisterScreen
import com.example.demo_app_kotlin.com_tam.components.screens.WelComeScreen
import com.example.kot104_xuongthuchanh.R
import com.example.kot104_xuongthuchanh.components.screens.auth.LoginScreen
import com.example.kot104_xuongthuchanh.components.screens.main.stacks.DetailProductScreen
import com.example.kot104_xuongthuchanh.components.screens.main.stacks.ProductInCategoryScreen
import com.example.kot104_xuongthuchanh.models.Cart
import com.example.kot104_xuongthuchanh.models.UserInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    readFormShared: UserInfo,
    userInfor: MutableState<UserInfo>,
    writeToShared: (UserInfo) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var isShowBottomSheet = remember { mutableStateOf(false) }
    var textContentBottomSheet = remember { mutableStateOf("") }


    val navControllerContainer = rememberNavController()

    val listCart = remember {
        mutableStateListOf<Cart>()
    }

    val addToCart: (Cart) -> Unit = { cart: Cart ->
        if (!listCart.any { it.Product.id == cart.Product.id }) {
            listCart.add(cart)
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Sản phẩm đã được thêm vào giỏ hàng"
        } else {
            for (item in listCart){
                if (item.Product.id == cart.Product.id){
                    item.quantity.value += cart.quantity.value
                    isShowBottomSheet.value = true
                    textContentBottomSheet.value = "Số lượng của sản phẩm trong giỏ hàng đã thành ${cart.quantity.value}"
                }
            }
        }
    }

    val changeQuantityCart: (Cart, Number: Int) -> Unit = { cart: Cart, number: Int ->
        for (item in listCart){
            if (item.Product.id == cart.Product.id){
                if (number < 0){
                    if (item.quantity.value == 1){
                        isShowBottomSheet.value = true
                        textContentBottomSheet.value = "Số lượng không thể nhỏ hơn 1"
                    }else{
                        item.quantity.value += number
                    }
                }else{
                    item.quantity.value += number
                }
            }else{
                isShowBottomSheet.value = true
                textContentBottomSheet.value = "Không tìm thấy sản phẩm trong giỏ hàng"
            }
        }
    }

    val orderCart: () -> Unit = {
        if (listCart.isNullOrEmpty()){
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Giỏ hàng chưa có sản phẩm !"
        }else{
            listCart.clear()
            isShowBottomSheet.value = true
            textContentBottomSheet.value = "Bạn đã mua hàng thành công !"
        }
    }

    val deleteItemCart: (Cart) -> Unit = { cart: Cart ->
        listCart.removeIf { item -> item.Product.id == cart.Product.id}
        isShowBottomSheet.value = true
        textContentBottomSheet.value = "Sản phẩm ${cart.Product.name} đã được xóa ra khỏi giỏ hàng của bạn !"
    }

    Scaffold { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            NavHost(navController = navControllerContainer,
                startDestination = if (!userInfor.value.email.isNullOrEmpty()) "MainTab" else "WelcomeScreen"){
                // Auth Screens
                composable("WelcomeScreen") { WelComeScreen(navControllerContainer)}
                composable("GetStartedScreen") { GetStartedScreen(navControllerContainer) }
                composable("RegisterScreen") { RegisterScreen(navControllerContainer, isShowBottomSheet, textContentBottomSheet) }
                composable("LoginScreen") { LoginScreen(navControllerContainer, isShowBottomSheet, textContentBottomSheet, writeToShared, userInfor) }

                composable("MainTab") { MainTab(navControllerContainer = navControllerContainer, listCart, changeQuantityCart, orderCart, deleteItemCart, writeToShared)}

                composable("ProductInCategoryScreen/{categoryId}",
                    arguments = listOf(navArgument("categoryId") {type = NavType.StringType})
                ) {
                    navBackStackEntry ->
                    val categoryId = navBackStackEntry.arguments?.getString("categoryId")
                    ProductInCategoryScreen(
                        navControllerContainer = navControllerContainer,
                        categoryId
                    )
                }

                composable("DetailProductScreen/{productId}",
                    arguments = listOf(navArgument("productId") {type = NavType.StringType})) {
                    navBackStackEntry ->
                    val productId = navBackStackEntry.arguments?.getString("productId")
                    DetailProductScreen(
                        navControllerContainer,
                        productId,
                        isShowBottomSheet,
                        textContentBottomSheet,
                        addToCart
                    )
                }
            }
        }

        if (isShowBottomSheet.value) {
            ModalBottomSheet(onDismissRequest = {
                coroutineScope.launch { sheetState.hide() }
                    .invokeOnCompletion { isShowBottomSheet.value = false }
            }) {
                containerContentBottomSheet(
                    coroutineScope,
                    sheetState,
                    isShowBottomSheet,
                    textContentBottomSheet
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun containerContentBottomSheet(
    coroutineScope: CoroutineScope,
    sheetState: SheetState,
    isShowBottomSheet: MutableState<Boolean>,
    textContentBottomSheet: MutableState<String>
) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "${textContentBottomSheet.value}", textAlign = TextAlign.Center, fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_bold)))
        Spacer(modifier = Modifier.height(20.dp))
        ElevatedButton(
            onClick = {
                coroutineScope.launch { sheetState.hide() }
                    .invokeOnCompletion { isShowBottomSheet.value = false }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                ),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                Color(android.graphics.Color.parseColor("#FF7400"))
            )
        ) {
            Text(
                text = "OK",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_10pt_semibold)),
                color = Color.White,
            )
        }
    }
}