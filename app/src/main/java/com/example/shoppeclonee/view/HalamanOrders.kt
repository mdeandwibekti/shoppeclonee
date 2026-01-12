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
import com.example.shoppeclonee.viewmodel.provider.OrderViewModel

@Composable
fun HalamanOrders(
    onBack: () -> Unit,
    vm: OrderViewModel = viewModel()
) {
    val userId = 1

    LaunchedEffect(Unit) { vm.getOrders(userId) }

    Scaffold(topBar = { TopAppBarLokalku("Pesanan Saya", onBack) }) { pad ->
        LazyColumn(Modifier.padding(pad)) {
            items(vm.orders.value ?: emptyList()) { o ->
                Text("${o.order_number} - ${o.status}")
            }
        }
    }
}
