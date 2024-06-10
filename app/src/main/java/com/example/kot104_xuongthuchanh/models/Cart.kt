package com.example.kot104_xuongthuchanh.models

import androidx.compose.runtime.MutableState
import com.example.kot104_xuongthuchanh.httpModel.categories.dataProducts

data class Cart(
    val Product: dataProducts,
    var quantity: MutableState<Int>
)
