package dev.proedva.androidassessmenteai.feature_operators.data.responsemodel

import com.google.gson.annotations.SerializedName
import dev.proedva.androidassessmenteai.feature_operators.domain.model.Operator

data class OperatorResponse(
    @SerializedName("valid")
    val valid: Boolean,
    @SerializedName("message")
    val message : String,
    @SerializedName("operatorList")
    val operatorList : List<Operator>
)