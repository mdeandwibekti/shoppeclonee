package com.example.shoppeclonee.repositori

import com.example.shoppeclonee.apiservice.ApiClient
import com.example.shoppeclonee.apiservice.ServiceApiProduct

class ProductRepository {

    private val api =
        ApiClient.retrofit.create(ServiceApiProduct::class.java)

    suspend fun getProducts() = api.getProducts()

    suspend fun getProductById(id: Int) = api.getProductById(id)

    suspend fun addProduct(token: String, body: Map<String, Any?>) =
        api.addProduct(token, body)

    suspend fun updateProduct(
        token: String,
        id: Int,
        body: Map<String, Any?>
    ) = api.updateProduct(token, id, body)

    suspend fun deleteProduct(token: String, id: Int) =
        api.deleteProduct(token, id)
}
