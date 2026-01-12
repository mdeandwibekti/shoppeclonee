package com.example.shoppeclonee.repositori

import com.example.shoppeclonee.apiservice.ApiClient
import com.example.shoppeclonee.apiservice.ServiceApiCart

class CartRepository {

    private val api = ApiClient.retrofit.create(ServiceApiCart::class.java)

    suspend fun getCart(userId: Int) = api.getCart(userId)

    suspend fun addToCart(userId: Int, productId: Int, qty: Int) =
        api.addToCart(
            mapOf(
                "user_id" to userId,
                "product_id" to productId,
                "quantity" to qty
            )
        )

    suspend fun removeItem(id: Int) = api.removeFromCart(id)

    suspend fun clearCart(userId: Int) = api.clearCart(userId)
}
