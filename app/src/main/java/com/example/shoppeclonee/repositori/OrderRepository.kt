package com.example.shoppeclonee.repositori

import com.example.shoppeclonee.apiservice.ApiClient
import com.example.shoppeclonee.apiservice.ServiceApiOrder

class OrderRepository {

    private val api = ApiClient.retrofit.create(ServiceApiOrder::class.java)

    suspend fun getOrders(userId: Int) = api.getOrders(userId)

    suspend fun createOrder(body: Map<String, Any?>) =
        api.createOrder(body)

    suspend fun updateStatus(id: Int, status: String) =
        api.updateOrderStatus(id, mapOf("status" to status))
}
