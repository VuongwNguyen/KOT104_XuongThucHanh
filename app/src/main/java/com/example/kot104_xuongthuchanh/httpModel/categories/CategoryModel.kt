package com.example.kot104_xuongthuchanh.httpModel.categories

import com.fasterxml.jackson.annotation.JsonProperty

data class CategoryResponse(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: List<dataCategoryResponse>?
)

data class dataCategoryResponse(
    @JsonProperty("category") val category: dataCategory,
    @JsonProperty("products") val products: List<dataProducts>
)

data class dataCategory(
    @JsonProperty("id") val id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String
)

data class dataProducts(
    @JsonProperty("id") val id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("price") val price: Int?,
    @JsonProperty("image_url") val image_url: String,
    @JsonProperty("categoryId") val categoryId: String,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String
)