package dev.proedva.androidassessmenteai.feature_operators.domain.model

import com.google.gson.annotations.SerializedName

data class Operator(
    @SerializedName("companyName")
    val companyName: String,
    @SerializedName("contactNumber")
    val contactNumber: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("operatorId")
    val operatorId: String,
    @SerializedName("physicalAddress")
    val physicalAddress: String,
    @SerializedName("registrationDetail")
    val registrationDetail: String,
    @SerializedName("tradingName")
    val tradingName: String,
    @SerializedName("vatNumber")
    val vatNumber: String,
    @SerializedName("website")
    val website: String
)