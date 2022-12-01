package dev.proedva.androidassessmenteai.feature_bookings.domain.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("additionalNotes")
    val additionalNotes: Any,
    @SerializedName("additionalNotes")
    val estimatedPrice: Double,
    @SerializedName("additionalNotes")
    val orderQuoteId: String,
    @SerializedName("additionalNotes")
    val quoteStatus: String
)