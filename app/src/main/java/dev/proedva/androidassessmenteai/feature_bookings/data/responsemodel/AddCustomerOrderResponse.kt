package dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel

data class AddCustomerOrderResponse(
    val message: String,
    val orderId: String,
    val valid: Boolean
)