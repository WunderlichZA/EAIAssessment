package dev.proedva.androidassessmenteai.request_data_models

import dev.proedva.androidassessmenteai.feature_bookings.domain.model.Trip

data class AddCustomerDataModel(
    val aircraftType: String,
    val capacity: Int,
    val customerId: String,
    val luggage: String,
    val orderType: String,
    val specialRequest: String,
    val tripList: List<Trip>
)