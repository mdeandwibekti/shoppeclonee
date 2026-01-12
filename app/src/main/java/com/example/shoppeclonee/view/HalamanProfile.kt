package com.example.shoppeclonee.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.shoppeclonee.repositori.ShoppeCloneApp
import com.example.shoppeclonee.view.components.ProfileMenuIcon
import com.example.shoppeclonee.viewmodel.provider.AuthViewModel

@Composable
fun HalamanProfile(
    navController: NavHostController,
    onLoginClick: () -> Unit,
    vm: AuthViewModel = viewModel()
) {
    val user = vm.user.value

    Scaffold(
        topBar = { TopAppBarLokalku("Profil") },
        bottomBar = { BottomBarLokalku(navController) }
    ) { pad ->

        Column(
            modifier = Modifier
                .padding(pad)
                .fillMaxSize()
        ) {

            // ================= BELUM LOGIN =================
            if (user == null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Spacer(Modifier.height(12.dp))

                    Text("Anda belum login")

                    Spacer(Modifier.height(16.dp))

                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Login")
                    }
                }
            }

            // ================= SUDAH LOGIN =================
            else {

                // -------- HEADER PROFIL --------
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        shape = CircleShape,
                        modifier = Modifier.size(64.dp),
                        color = MaterialTheme.colorScheme.primary
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                user.username.first().uppercase(),
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium
                            )
                        }
                    }

                    Spacer(Modifier.width(12.dp))

                    Column {
                        Text(
                            user.username,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(user.email ?: "-", style = MaterialTheme.typography.bodySmall)
                        Text(
                            "Role: ${user.role}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))

                // -------- PESANAN --------
                Text(
                    "Pesanan Saya",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleSmall
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ProfileMenuIcon(Icons.Default.Payment, "Belum Bayar")
                    ProfileMenuIcon(Icons.Default.Inventory, "Dikemas")
                    ProfileMenuIcon(Icons.Default.LocalShipping, "Dikirim")
                }

                Spacer(Modifier.height(16.dp))

                // -------- AKTIVITAS --------
                Text(
                    "Aktivitas",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleSmall
                )

                ListItem(
                    headlineContent = { Text("Favorit Saya") },
                    leadingContent = { Icon(Icons.Default.Favorite, null) }
                )

                // KHUSUS SELLER
                if (user.role == "seller") {
                    ListItem(
                        headlineContent = { Text("Dashboard Seller") },
                        leadingContent = { Icon(Icons.Default.Store, null) },
                        modifier = Modifier.clickable {
                            navController.navigate("seller_home")
                        }
                    )
                }

                Divider()

                ListItem(
                    headlineContent = { Text("Logout") },
                    leadingContent = {
                        Icon(Icons.Default.Logout, null, tint = MaterialTheme.colorScheme.error)
                    },
                    modifier = Modifier.clickable {
                        vm.logout()
                        navController.navigate("home") {
                            popUpTo(0)
                        }
                    }
                )
            }
        }
    }
}


