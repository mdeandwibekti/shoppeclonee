package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.shoppeclonee.repositori.ShoppeCloneApp
import com.example.shoppeclonee.viewmodel.provider.AuthViewModel

@Composable
fun HalamanSellerHome(
    navController: NavHostController,
    vm: AuthViewModel = viewModel()

) {
    Scaffold(
        topBar = { TopAppBarLokalku("Dashboard Seller") },

        // ✅ BOTTOM BAR DITAMBAHKAN
        bottomBar = {
            BottomBarLokalku(navController)
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("product_add") }
            ) {
                Text("+", style = MaterialTheme.typography.titleLarge)
            }
        }
    ) { pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Selamat datang 👋",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Kelola produk UMKM Anda dengan mudah",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "📦 Produk",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "Tambah, edit, dan hapus produk Anda",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Text(
                text = "Gunakan tombol + untuk menambahkan produk baru",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
