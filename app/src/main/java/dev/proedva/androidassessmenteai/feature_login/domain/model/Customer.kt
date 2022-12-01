package dev.proedva.androidassessmenteai.feature_login.domain.model

import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("aircraftTypeValueList")
    val aircraftTypeValueList: List<String?>,
    @SerializedName("customerId")
    val customerId: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("emptyFlightLeadStatusValueList")
    val emptyFlightLeadStatusValueList: List<String?>,
    @SerializedName("emptyFlightStatusValueList")
    val emptyFlightStatusValueList: List<String?>,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("idNumber")
    val idNumber: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("luggageValueList")
    val luggageValueList: List<String?>,
    @SerializedName("message")
    val message: String,
    @SerializedName("mobileNumber")
    val mobileNumber: String?,
    @SerializedName("orderQuoteStatusValueList")
    val orderQuoteStatusValueList: List<String?>,
    @SerializedName("orderStatusValueList")
    val orderStatusValueList: List<String?>,
    @SerializedName("orderTypeValueList")
    val orderTypeValueList: List<String?>,
    @SerializedName("passportNumber")
    val passportNumber: String?,
    @SerializedName("physicalAddress")
    val physicalAddress: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("valid")
    val valid: Boolean
)