package com.example.shoppeclonee.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.shoppeclonee.uicontroller.route.DestinasiHome
import com.example.shoppeclonee.uicontroller.route.DestinasiNotifikasi
import com.example.shoppeclonee.uicontroller.route.DestinasiProfile

@Composable
fun BottomBarLokalku(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(DestinasiHome.route) },
            icon = { Icon(Icons.Default.Home, null) },
            label = { Text("Beranda") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(DestinasiNotifikasi.route) },
            icon = { Icon(Icons.Default.Notifications, null) },
            label = { Text("Notifikasi") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(DestinasiProfile.route) },
            icon = { Icon(Icons.Default.Person, null) },
            label = { Text("Profil") }
        )
    }
}

