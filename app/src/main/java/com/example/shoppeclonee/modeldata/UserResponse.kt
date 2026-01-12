package com.example.shoppeclonee.modeldata

data class LoginResponse(
    val status: Boolean,
    val message: String,
    val user: User?
)

data class BaseResponse(
    val status: Boolean,
    val message: String
)

