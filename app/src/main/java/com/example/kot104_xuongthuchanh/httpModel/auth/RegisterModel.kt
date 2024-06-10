package com.example.kot104_xuongthuchanh.httpModel.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterRequest(
    @JsonProperty("fullname") val fullname: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String
)

data class RegisterResponse(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: dataRegisterResponse
)

data class dataRegisterResponse(
    @JsonProperty("id") val id: String,
    @JsonProperty("fullname") val fullname: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("updatedAt") val updatedAt: String,
    @JsonProperty("createdAt") val createdAt: String
)