package dev.proedva.androidassessmenteai.feature_bookings.domain.model

data class OrderItem(
    val aircraftType: String,
    val capacity: Int,
    val luggage: String,
    val orderId: String,
    val orderStatus: String,
    val orderType: String,
    val quoteList: List<Quote>,
    val specialRequest: String,
    val tripList: List<Trip>
)