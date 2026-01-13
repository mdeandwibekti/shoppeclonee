package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppeclonee.viewmodel.provider.CartViewModel

@Composable
fun HalamanCart(
    onCheckout: () -> Unit,
    onBack: () -> Unit,
    vm: CartViewModel = viewModel()
) {

    // ✅ TANPA userId
    LaunchedEffect(Unit) {
        vm.getCart()
    }

    Scaffold(
        topBar = { TopAppBarLokalku("Keranjang", onBack) }
    ) { pad ->

        Column(
            modifier = Modifier.padding(pad)
        ) {

            LazyColumn {
                items(vm.cart.value) { item ->
                    Text(
                        text = "Produk ID: ${item.product_id} x${item.quantity}"
                    )
                }
            }


            Button(
                onClick = onCheckout
            ) {
                Text("Checkout")
            }
        }
    }
}
