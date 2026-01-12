package com.example.shoppeclonee.apiservice

import com.example.shoppeclonee.modeldata.Product
import retrofit2.http.*

interface ServiceApiProduct {

    @GET("api/products")
    suspend fun getProducts(): List<Product>

    @GET("api/products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Product

    @POST("api/products")
    suspend fun addProduct(
        @Header("Authorization") token: String,
        @Body body: Map<String, Any?>
    ): BaseResponse

    @PUT("api/products/{id}")
    suspend fun updateProduct(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body body: Map<String, Any?>
    ): BaseResponse

    @DELETE("api/products/{id}")
    suspend fun deleteProduct(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): BaseResponse
}
