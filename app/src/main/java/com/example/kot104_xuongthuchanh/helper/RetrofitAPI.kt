package com.example.kot104_xuongthuchanh.helper

import android.util.Log
import com.example.kot104_xuongthuchanh.httpModel.auth.LoginRequest
import com.example.kot104_xuongthuchanh.httpModel.auth.LoginResponse
import com.example.kot104_xuongthuchanh.httpModel.auth.RegisterRequest
import com.example.kot104_xuongthuchanh.httpModel.auth.RegisterResponse
import com.example.kot104_xuongthuchanh.httpModel.categories.CategoryResponse
import com.example.kot104_xuongthuchanh.httpModel.products.DetailProductResponse
import com.example.kot104_xuongthuchanh.httpModel.products.ProductsByCategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitAPI {
    private  val retrofit = RetrofitClient.getClient()
    private  val interfaceRetrofit = retrofit.create(InterfaceRetrofit::class.java)

    fun register(body: RegisterRequest,
                 callback: (RegisterResponse?) -> Unit){
        interfaceRetrofit.register(body).enqueue(
            object : Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>,
                                        response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        val registerResponseModel = response.body()
                        callback(registerResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }

    fun login(body: LoginRequest,
              callback: (LoginResponse?) -> Unit){
        interfaceRetrofit.login(body).enqueue(
            object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>,
                                        response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val loginResponseModel = response.body()
                        callback(loginResponseModel)
                    } else {
                        Log.d(">>>Failed to login", response.message())
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("Failed to login", t.message ?: "Unknown error")
                }
            })
    }


    fun getCategories(callback: (CategoryResponse?) -> Unit){
        interfaceRetrofit.getAllCategories().enqueue(object : Callback<CategoryResponse> {
            override  fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                if ( response.isSuccessful) {
                    callback(response.body())
                }else {
                    println("error to getCategory: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("Failed to getCategory", t.printStackTrace().toString())
                t.printStackTrace()
            }
        })
    }

    fun getProductsByCategory(categoryId: String,
                              callback: (ProductsByCategoryResponse?) -> Unit) {
        interfaceRetrofit.getPrudctsByCategory(categoryId).enqueue(
            object : Callback<ProductsByCategoryResponse> {
                override fun onResponse(
                    call: Call<ProductsByCategoryResponse>,
                    response: Response<ProductsByCategoryResponse>
                ) {
                    if (response.isSuccessful){
                        callback(response.body())
                    }else{
                        Log.d(">>> Failed to products by category", "onResponse: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ProductsByCategoryResponse>, t: Throwable) {
                    Log.d("Failed to detail product", t.message ?: "Unknown error")
                }
            }
        )
    }

    fun getDetailProduct(productId: String,
                         callback: (DetailProductResponse?) -> Unit){
        interfaceRetrofit.getDetailProduct(productId).enqueue(
            object : Callback<DetailProductResponse> {
                override fun onResponse(
                    call: Call<DetailProductResponse>,
                    response: Response<DetailProductResponse>
                ) {
                    if (response.isSuccessful){
                        callback(response.body())
                    }else{
                        Log.d(">>> Failed to detail product", "onResponse: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<DetailProductResponse>, t: Throwable) {
                    Log.d("Failed to detail product", t.message ?: "Unknown error")
                }
            }
        )
    }
}