package com.example.shoppeclonee.apiservice


import com.example.shoppeclonee.modeldata.CartItem
import retrofit2.http.*

interface ServiceApiCart {

    @GET("api/cart/{userId}")
    suspend fun getCart(
        @Path("userId") userId: Int
    ): List<CartItem>

    @POST("api/cart")
    suspend fun addToCart(
        @Body body: Map<String, Any>
    ): BaseResponse

    @DELETE("api/cart/{id}")
    suspend fun removeFromCart(
        @Path("id") id: Int
    ): BaseResponse

    @DELETE("api/cart/user/{userId}")
    suspend fun clearCart(
        @Path("userId") userId: Int
    ): BaseResponse
}
