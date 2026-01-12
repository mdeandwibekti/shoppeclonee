package com.example.shoppeclonee.repositori

import com.example.shoppeclonee.apiservice.ApiClient
import com.example.shoppeclonee.apiservice.ServiceApiTransaction

class TransactionRepository {

    private val api = ApiClient.retrofit.create(ServiceApiTransaction::class.java)

    suspend fun getTransactions(userId: Int) =
        api.getTransactions(userId)

    suspend fun createTransaction(body: Map<String, Any?>) =
        api.createTransaction(body)
}
