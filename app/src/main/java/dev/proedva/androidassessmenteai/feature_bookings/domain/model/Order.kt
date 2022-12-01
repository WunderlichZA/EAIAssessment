package dev.proedva.androidassessmenteai.feature_bookings.domain.model

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("aircraftType")
    val aircraftType: String,
    @SerializedName("capacity")
    val capacity: Int,
    @SerializedName("luggage")
    val luggage: String,
    @SerializedName("orderId")
    val orderId: String,
    @SerializedName("orderStatus")
    val orderStatus: String,
    @SerializedName("orderType")
    val orderType: String,
    @SerializedName("quoteList")
    val quoteList: List<Quote>,
    @SerializedName("specialRequest")
    val specialRequest: String,
    @SerializedName("tripList")
    val tripList: List<Trip>
)