package com.example.shoppeclonee.repositori


import com.example.shoppeclonee.apiservice.ApiClient
import com.example.shoppeclonee.apiservice.LoginResponse
import com.example.shoppeclonee.apiservice.ServiceApiUser
import com.example.shoppeclonee.modeldata.User

class AuthRepository {

    private val api = ApiClient.retrofit.create(ServiceApiUser::class.java)

    suspend fun register(
        username: String,
        email: String,
        password: String,
        role: String
    ) = api.register(
        mapOf(
            "username" to username,
            "email" to email,
            "password" to password,
            "role" to role
        )
    )

    suspend fun login(email: String, password: String) =
        api.login(
            mapOf(
                "email" to email,
                "password" to password
            )
        )

    suspend fun getUser(id: Int) = api.getUser(id)
}

