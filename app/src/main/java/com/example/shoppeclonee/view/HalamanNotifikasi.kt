package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanNotifikasi(
    navController: NavHostController
) {

    val dummy = listOf(
        "Pesanan kamu sedang diproses",
        "Produk baru dari UMKM favoritmu!",
        "Promo diskon khusus hari ini"
    )

    Scaffold(
        topBar = {
            TopAppBarLokalku("Notifikasi")
        },
        bottomBar = {
            BottomBarLokalku(navController)
        }
    ) { pad ->

        if (dummy.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad),
                contentAlignment = Alignment.Center
            ) {
                Text("Belum ada notifikasi")
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(pad)
            ) {
                items(dummy) { notif ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = notif,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
