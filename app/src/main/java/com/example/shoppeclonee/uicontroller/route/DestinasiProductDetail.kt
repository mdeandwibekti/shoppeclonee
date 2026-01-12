package com.example.shoppeclonee.uicontroller.route

object DestinasiProductDetail {
    const val route = "product_detail"
    const val argProductId = "productId"

    fun createRoute(id: Int) = "$route/$id"
}