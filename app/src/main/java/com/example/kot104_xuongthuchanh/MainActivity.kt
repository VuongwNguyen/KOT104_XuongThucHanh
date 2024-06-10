package com.example.kot104_xuongthuchanh

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.kot104_xuongthuchanh.models.UserInfo
import com.example.kot104_xuongthuchanh.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // hàm đọc thông tin user từ shared preferences
            fun readFormShared(): UserInfo {
                val sharedPref = getPreferences(Context.MODE_PRIVATE)
                return UserInfo(
                    userId = sharedPref.getString("userId", null),
                    email = sharedPref.getString("email", null),
                    fullname = sharedPref.getString("fullname", null)
                )
            }

            var userInfor = remember {
                mutableStateOf(readFormShared())
            }

            // hàm lưu thông tin user vào shared preferences
            val writeToShared: (UserInfo) -> Unit = { userInfoFromLogin ->
                val sharedPref = getPreferences(Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("userId", userInfoFromLogin.userId)
                    putString("email", userInfoFromLogin.email)
                    putString("fullname", userInfoFromLogin.fullname)
                    apply()
                }
                // cập nhật state
                userInfor.value = userInfoFromLogin
            }


            Navigation(readFormShared(), userInfor, writeToShared)
        }
    }
}