package com.example.kot104_xuongthuchanh.helper

import com.example.kot104_xuongthuchanh.httpModel.auth.LoginRequest
import com.example.kot104_xuongthuchanh.httpModel.auth.LoginResponse
import com.example.kot104_xuongthuchanh.httpModel.auth.RegisterRequest
import com.example.kot104_xuongthuchanh.httpModel.auth.RegisterResponse
import com.example.kot104_xuongthuchanh.httpModel.categories.CategoryResponse
import com.example.kot104_xuongthuchanh.httpModel.products.DetailProductResponse
import com.example.kot104_xuongthuchanh.httpModel.products.ProductsByCategoryResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface InterfaceRetrofit {

    @POST("api/account/create")
    fun register(@Body body: RegisterRequest) : Call<RegisterResponse>

    @POST("api/account/login")
    fun login(@Body body: LoginRequest) : Call<LoginResponse>

    @GET("api/product/getAllProductsWithCategory")
    fun getAllCategories() : Call<CategoryResponse>

    @GET("api/product/getAllProductsByCategory/{categoryId}")
    fun getPrudctsByCategory(
        @Path("categoryId") categoryId: String
    ) : Call<ProductsByCategoryResponse>

    @GET("api/product/getProductById/{productId}")
    fun getDetailProduct(
        @Path("productId") productId: String
    ) : Call<DetailProductResponse>
}