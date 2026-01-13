package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppeclonee.viewmodel.provider.AuthViewModel
import com.example.shoppeclonee.viewmodel.provider.OrderViewModel

@Composable
fun HalamanOrder(
    onBack: () -> Unit,
    authVm: AuthViewModel = viewModel(),
    orderVm: OrderViewModel = viewModel(),
    token: String,
    vm: OrderViewModel = viewModel()
) {

    val token = authVm.user.value?.token ?: ""

    LaunchedEffect(Unit) {
        if (token.isNotEmpty()) {
            orderVm.loadOrders(token)
        }
    }

    Scaffold(
        topBar = { TopAppBarLokalku("Pesanan", onBack) }
    ) { pad ->

        LazyColumn(
            modifier = Modifier.padding(pad)
        ) {
            items(orderVm.orders.value) { order ->
                Text("Order ID: ${order.id}")
            }
        }
    }
}