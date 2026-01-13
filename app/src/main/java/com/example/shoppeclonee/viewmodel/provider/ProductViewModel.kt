package com.example.shoppeclonee.viewmodel.provider

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.shoppeclonee.modeldata.Product
import com.example.shoppeclonee.repositori.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repo: ProductRepository = ProductRepository()
) : ViewModel() {

    val products = mutableStateOf<List<Product>>(emptyList())val message = mutableStateOf("")

    // sementara (nanti ambil dari AuthViewModel)
    private val token = "Bearer TOKEN_LOGIN_KAMU"
    val loading = MutableLiveData(false)
    val product = MutableLiveData<Product?>()


    fun loadProducts() = viewModelScope.launch {
        products.value = repo.getAllProducts()
    }

    fun addProduct(
        token: String,
        name: String,
        price: Int,
        stock: Int,
        description: String
    ) = viewModelScope.launch {
        repo.createProduct(token, name, price, stock, description)
        loadProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            loading.value = true
            try {
                products.value = repo.getProducts()
            } catch (e: Exception) {
                message.value = e.message
            } finally {
                loading.value = false
            }
        }
    }

    fun getProductById(id: Int) {
        viewModelScope.launch {
            try {
                product.value = repo.getProductById(id)
            } catch (e: Exception) {
                message.value = e.message
            }
        }
    }


    fun getProductDetail(id: Int) {
        viewModelScope.launch {
            product.value = repo.getProductById(id)
        }
    }


    fun updateProduct(id: Int, body: Map<String, Any?>) {
        viewModelScope.launch {
            try {
                message.value = repo.updateProduct(token, id, body).message
            } catch (e: Exception) {
                message.value = e.message
            }
        }
    }

    fun deleteProduct(id: Int) {
        viewModelScope.launch {
            try {
                message.value = repo.deleteProduct(token, id).message
            } catch (e: Exception) {
                message.value = e.message
            }
        }
    }


}
