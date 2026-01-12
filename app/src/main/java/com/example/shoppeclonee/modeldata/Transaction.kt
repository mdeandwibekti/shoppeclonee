package com.example.shoppeclonee.modeldata

data class Transaction(
    val id: Int,
    val user_id: Int,
    val product_id: Int?,
    val status: String,
    val createdAt: String,
    val updatedAt: String
)
