package com.example.shoppeclonee.viewmodel.provider


import androidx.lifecycle.*
import com.example.shoppeclonee.modeldata.Order
import com.example.shoppeclonee.repositori.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    private val repo = OrderRepository()

    val loading = MutableLiveData(false)
    val orders = MutableLiveData<List<Order>>()
    val message = MutableLiveData<String?>()

    fun getOrders(userId: Int) {
        viewModelScope.launch {
            loading.value = true
            try {
                orders.value = repo.getOrders(userId)
            } catch (e: Exception) {
                message.value = e.message
            } finally {
                loading.value = false
            }
        }
    }

    fun createOrder(body: Map<String, Any?>) {
        viewModelScope.launch {
            try { message.value = repo.createOrder(body).message }
            catch (e: Exception) { message.value = e.message }
        }
    }

    fun updateStatus(id: Int, status: String) {
        viewModelScope.launch {
            try { message.value = repo.updateStatus(id, status).message }
            catch (e: Exception) { message.value = e.message }
        }
    }
}
