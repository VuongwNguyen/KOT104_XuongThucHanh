package com.example.kot104_xuongthuchanh.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo_app_kotlin.com_tam.components.screens.GetStartedScreen
import com.example.demo_app_kotlin.com_tam.components.screens.RegisterScreen
import com.example.demo_app_kotlin.com_tam.components.screens.WelComeScreen
import com.example.kot104_xuongthuchanh.components.screens.auth.LoginScreen

@Composable
fun Navigation(){
    val Nav_Controller = rememberNavController()
    NavHost(navController = Nav_Controller, startDestination = "WelcomeScreen"){
        // Auth Screens
        composable("WelcomeScreen") { WelComeScreen(Nav_Controller)}
        composable("GetStartedScreen") { GetStartedScreen(Nav_Controller) }
        composable("RegisterScreen") { RegisterScreen(Nav_Controller) }
        composable("LoginScreen") { LoginScreen(Nav_Controller) }

    }
}