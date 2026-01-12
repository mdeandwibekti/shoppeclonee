package com.example.shoppeclonee.modeldata

data class CartItem(
    val id: Int,
    val user_id: Int,
    val product_id: Int,
    val quantity: Int,
    val product: Product? = null
)
