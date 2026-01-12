package com.example.shoppeclonee.uicontroller.route

import HalamanLogin
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.shoppeclonee.view.*

@Composable
fun PetaNavigasi(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route
    ) {

        // ================= HOME =================
        composable(DestinasiHome.route) {
            HalamanHome(
                navController = navController,
                onProductClick = { productId ->
                    navController.navigate(
                        DestinasiProductDetail.createRoute(productId)
                    )
                }
            )
        }

        composable("login") {
            HalamanLogin(
                onLoginSuccess = { role ->
                    if (role == "seller") {
                        navController.navigate("seller_home") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        navController.navigate("user_home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                },
                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        composable("user_home") {
            HalamanHome(
                navController = navController,
                onProductClick = { id ->
                    navController.navigate("product_detail/$id")
                }
            )
        }

        composable("seller_home") {
            HalamanSellerHome(
                navController = navController
            )
        }


        composable("register") {
            HalamanRegister(
                onBack = { navController.popBackStack() }
            )
        }



        // ============== PRODUCT DETAIL ============
        composable(
            route = "${DestinasiProductDetail.route}/{${DestinasiProductDetail.argProductId}}",
            arguments = listOf(
                navArgument(DestinasiProductDetail.argProductId) {
                    type = NavType.IntType
                }
            )
        ) { backStack ->
            val productId =
                backStack.arguments?.getInt(DestinasiProductDetail.argProductId) ?: 0

            HalamanProductDetail(
                productId = productId,
                onBack = { navController.popBackStack() }
            )
        }

        // ================= CART =================
        composable(DestinasiCart.route) {
            HalamanCart(
                onCheckout = {
                    navController.navigate(DestinasiOrder.route)
                },
                onBack = { navController.popBackStack() }
            )
        }

        // ================= ORDERS =================
        composable(DestinasiOrder.route) {
            HalamanOrders(
                onBack = { navController.popBackStack() }
            )
        }

        // ================= SELLER =================
        composable(DestinasiSellerDashboard.route) {
            HalamanSellerProductList(
                onAddProduct = {
                    navController.navigate("product_entry")
                },
                onEditProduct = { productId ->
                    navController.navigate("product_edit/$productId")
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }


        // Entry input produk (opsional sementara)
        composable("product_entry") {
            HalamanProductEntry(
                onBack = { navController.popBackStack() }
            )
        }

        composable("checkout") {
            HalamanCheckout(
                onOrderCreated = {
                    navController.navigate(DestinasiOrder.route)
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(DestinasiNotifikasi.route) {
            HalamanNotifikasi(
                navController = navController
            )
        }

        composable(DestinasiProfile.route) {
            HalamanProfile(
                navController = navController,
                onLoginClick = {
                    navController.navigate("login")
                }
            )
        }

        composable("seller_products") {
            HalamanSellerProductList(
                onAddProduct = {
                    navController.navigate("product_entry")
                },
                onEditProduct = { id ->
                    navController.navigate("product_edit/$id")
                },
                onBack = { navController.popBackStack() }
            )
        }

    }
}
