package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppeclonee.viewmodel.provider.CartViewModel
import com.example.shoppeclonee.viewmodel.provider.OrderViewModel

@Composable
fun HalamanCheckout(
    onOrderCreated: () -> Unit,
    onBack: () -> Unit,
    cartVm: CartViewModel = viewModel(),
    orderVm: OrderViewModel = viewModel()
) {

    // 🔧 sementara (nanti dari Auth/session)
    val userId = 1

    // ✅ FIX: TANPA parameter
    LaunchedEffect(Unit) {
        cartVm.getCart()
    }

    val cartItems = cartVm.cart.value ?: emptyList()

    // 🔧 sementara harga dummy
    val total = cartItems.sumOf { it.quantity * 10000 }
    val orderVM: OrderViewModel = viewModel()

    Scaffold(
        topBar = { TopAppBarLokalku("Checkout", onBack) }
    ) { pad ->

        Column(
            modifier = Modifier
                .padding(pad)
                .padding(16.dp)
        ) {

            Text(
                text = "Ringkasan Pesanan",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(10.dp))

            LazyColumn {
                items(cartItems) { item ->
                    Text(
                        text = "Produk ID: ${item.product_id} x${item.quantity}"
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            Text("Total: Rp $total")

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    orderVM.createOrder(token = "dummy")
                }
            ) {
                Text("Buat Order")
            }

            orderVm.message.value?.let {
                Spacer(Modifier.height(8.dp))
                Text(it)
            }
        }
    }
}
