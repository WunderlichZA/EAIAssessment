package dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel

import com.google.gson.annotations.SerializedName
import dev.proedva.androidassessmenteai.feature_bookings.domain.model.OrderItem

data class OrderResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("orderItemList")
    val orderItemList: List<OrderItem>,
    @SerializedName("valid")
    val valid: Boolean
)