package com.example.shoppeclonee.viewmodel.provider


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.shoppeclonee.modeldata.Order
import com.example.shoppeclonee.repositori.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel(
    private val repo: OrderRepository = OrderRepository()
) : ViewModel() {

    var orders = mutableStateOf<List<Order>>(emptyList())
        private set
    var order = mutableStateOf<Order?>(null)
        private set

    var message = mutableStateOf("")
        private set

    fun loadOrders(token: String) {
        viewModelScope.launch {
            val res = repo.getOrders(token)
            orders.value = res.data ?: emptyList()
        }
    }


    fun createOrder(token: String) {
        viewModelScope.launch {
            try {
                val res = repo.createOrder(token)
                message.value = res.message} catch (e: Exception) {
                message.value = "Gagal membuat order"
            }
        }
    }



    fun checkout(token: String) = viewModelScope.launch {
        val res = repo.createOrder(token)
        message.value = res.message
    }

}

