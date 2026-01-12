package com.example.shoppeclonee.viewmodel.provider

import androidx.lifecycle.*
import com.example.shoppeclonee.modeldata.CartItem
import com.example.shoppeclonee.repositori.CartRepository
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {

    private val repo = CartRepository()

    // 🔐 sementara hardcode / nanti ambil dari AuthViewModel / Session
    private val userId = 1

    val loading = MutableLiveData(false)
    val cart = MutableLiveData<List<CartItem>>()
    val message = MutableLiveData<String?>()

    fun getCart() {
        viewModelScope.launch {
            loading.value = true
            try {
                cart.value = repo.getCart(userId)
            } catch (e: Exception) {
                message.value = e.message
            } finally {
                loading.value = false
            }
        }
    }

    // ✅ SESUAI HALAMAN HOME
    fun addToCart(productId: Int, qty: Int) {
        viewModelScope.launch {
            try {
                message.value = repo.addToCart(
                    userId = userId,
                    productId = productId,
                    qty = qty
                ).message
            } catch (e: Exception) {
                message.value = e.message
            }
        }
    }

    fun removeItem(cartItemId: Int) {
        viewModelScope.launch {
            try {
                message.value = repo.removeItem(cartItemId).message
            } catch (e: Exception) {
                message.value = e.message
            }
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            try {
                message.value = repo.clearCart(userId).message
            } catch (e: Exception) {
                message.value = e.message
            }
        }
    }
}
