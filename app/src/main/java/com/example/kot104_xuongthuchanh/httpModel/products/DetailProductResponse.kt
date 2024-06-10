package com.example.kot104_xuongthuchanh.httpModel.products

import com.example.kot104_xuongthuchanh.httpModel.categories.dataProducts
import com.fasterxml.jackson.annotation.JsonProperty

data class DetailProductResponse(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: dataDetailProduct
)

data class dataDetailProduct(
    @JsonProperty("products") val products: dataProducts
)
