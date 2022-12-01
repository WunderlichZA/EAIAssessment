package dev.proedva.androidassessmenteai.feature_bookings.domain.model

import com.google.gson.annotations.SerializedName

data class Trip(
    @SerializedName("locationFrom")
    val locationFrom: String,
    @SerializedName("locationTo")
    val locationTo: String,
    @SerializedName("orderTripId")
    val orderTripId: String,
    @SerializedName("travelDate")
    val travelDate: String
)