package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppeclonee.viewmodel.provider.ProductViewModel

@Composable
fun HalamanProductDetail(
    productId: Int,
    onBack: () -> Unit,
    vm: ProductViewModel = viewModel()
) {
    LaunchedEffect(productId) {
        vm.getProductDetail(productId)
    }

    val product = vm.product.value

    Scaffold(
        topBar = { TopAppBarLokalku(product?.name ?: "Detail Produk", onBack) }
    ) { pad ->
        if (product == null) {
            Text("Memuat...", Modifier.padding(pad))
        } else {
            Column(Modifier.padding(16.dp)) {
                Text(product.name, style = MaterialTheme.typography.titleLarge)
                Text("Harga: Rp ${product.price}")
                Text(product.description ?: "-")
            }
        }
    }
}
