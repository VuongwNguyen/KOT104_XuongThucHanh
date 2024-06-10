package com.example.kot104_xuongthuchanh.httpModel.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequest(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String
)

data class LoginResponse(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: dataLoginResponse
)

data class dataLoginResponse(
    @JsonProperty("id") val id: String,
    @JsonProperty("fullname") val fullname: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String
)