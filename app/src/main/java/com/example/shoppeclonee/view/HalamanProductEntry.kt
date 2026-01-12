package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppeclonee.viewmodel.provider.ProductViewModel

@Composable
fun HalamanProductEntry(
    token: String,
    onBack: () -> Unit,
    vm: ProductViewModel = viewModel()
) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBarLokalku("Tambah Produk", onBack) }
    ) { pad ->

        Column(Modifier.padding(pad).padding(16.dp)) {

            OutlinedTextField(name, { name = it }, label = { Text("Nama") })
            OutlinedTextField(price, { price = it }, label = { Text("Harga") })
            OutlinedTextField(stock, { stock = it }, label = { Text("Stok") })

            Spacer(Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    vm.addProduct(
                        token,
                        mapOf(
                            "name" to name,
                            "price" to price,
                            "stock" to stock.toInt()
                        )
                    )
                    onBack()
                }
            ) {
                Text("Simpan")
            }
        }
    }
}

