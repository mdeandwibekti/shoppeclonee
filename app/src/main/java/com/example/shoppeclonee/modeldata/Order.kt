package com.example.shoppeclonee.modeldata

data class Order(
    val id: Int,
    val user_id: Int,
    val order_number: String,
    val total_price: Double,
    val status: String
)
