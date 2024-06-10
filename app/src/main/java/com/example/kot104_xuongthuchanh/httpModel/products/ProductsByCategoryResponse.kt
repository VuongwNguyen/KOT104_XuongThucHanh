package com.example.kot104_xuongthuchanh.httpModel.products

import com.example.kot104_xuongthuchanh.httpModel.categories.dataProducts
import com.fasterxml.jackson.annotation.JsonProperty

data class ProductsByCategoryResponse(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: dataProductByCategory
)

data class dataProductByCategory(
    @JsonProperty("nameCategory") val nameCategory: nameCategory,
    @JsonProperty("products") val products: List<dataProducts>?
)

data class nameCategory(
    @JsonProperty("name") val name: String
)
