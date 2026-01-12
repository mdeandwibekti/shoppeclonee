package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.shoppeclonee.viewmodel.provider.SellerViewModel

@Composable
fun HalamanSellerProductList(
    navController: NavHostController,
    token: String,
    vm: SellerViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        vm.loadSellerProducts()
    }

    Scaffold(
        topBar = { TopAppBarLokalku("Produk Saya") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("product_add") }
            ) { Text("+") }
        }
    ) { pad ->

        LazyColumn(
            modifier = Modifier.padding(pad).padding(12.dp)
        ) {

            items(vm.myProducts.value ?: emptyList()) { p ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Column(Modifier.padding(12.dp)) {

                        Text(p.name, fontWeight = FontWeight.Bold)
                        Text("Rp ${p.price}")
                        Text("Stok: ${p.stock}")

                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            TextButton(
                                onClick = {
                                    navController.navigate("product_edit/${p.id}")
                                }
                            ) { Text("Edit") }

                            TextButton(
                                onClick = {
                                    vm.deleteProduct(token, p.id)
                                }
                            ) {
                                Text("Hapus", color = Color.Red)
                            }
                        }
                    }
                }
            }
        }
    }
}


