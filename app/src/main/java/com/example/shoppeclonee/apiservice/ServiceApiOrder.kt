package com.example.shoppeclonee.apiservice


import com.example.shoppeclonee.modeldata.Order
import retrofit2.http.*

interface ServiceApiOrder {

    @GET("api/orders/{userId}")
    suspend fun getOrders(
        @Path("userId") userId: Int
    ): List<Order>

    @POST("api/orders")
    suspend fun createOrder(
        @Body body: Map<String, Any?>
    ): BaseResponse

    @PUT("api/orders/{id}/status")
    suspend fun updateOrderStatus(
        @Path("id") id: Int,
        @Body body: Map<String, String>
    ): BaseResponse
}
