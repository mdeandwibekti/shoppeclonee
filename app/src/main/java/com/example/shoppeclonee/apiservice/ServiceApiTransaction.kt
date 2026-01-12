package com.example.shoppeclonee.apiservice


import com.example.shoppeclonee.modeldata.Transaction
import retrofit2.http.*

interface ServiceApiTransaction {

    @GET("api/transactions/{userId}")
    suspend fun getTransactions(
        @Path("userId") userId: Int
    ): List<Transaction>

    @POST("api/transactions")
    suspend fun createTransaction(
        @Body body: Map<String, Any?>
    ): BaseResponse
}
