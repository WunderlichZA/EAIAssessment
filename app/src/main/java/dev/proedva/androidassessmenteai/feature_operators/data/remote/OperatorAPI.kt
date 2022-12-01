package dev.proedva.androidassessmenteai.feature_operators.data.remote

import dev.proedva.androidassessmenteai.request_data_models.OperationsRequestDataModel
import dev.proedva.androidassessmenteai.feature_operators.data.responsemodel.OperatorResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OperatorAPI {
    @POST("airoceanos-api/customer/operator/query/list")
    suspend fun getOperators(@Body operationsRequestDataModel: OperationsRequestDataModel) : OperatorResponse
}