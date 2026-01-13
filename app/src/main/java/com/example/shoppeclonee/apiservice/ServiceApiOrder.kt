package com.example.shoppeclonee.apiservice


import com.example.shoppeclonee.modeldata.Order
import retrofit2.http.*


data class OrderResponse(
    val msg: String? = null,
    val data: List<Order>? = emptyList()
)
interface ServiceApiOrder {

    @POST("api/orders")
    suspend fun createOrder(
        @Header("Authorization") token: String
    ): BaseResponse

    @GET("api/orders")
    suspend fun getOrders(
        @Header("Authorization") token: String
    ): OrderResponse
}

