package dev.proedva.androidassessmenteai.feature_operators.domain.repository

import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.request_data_models.OperationsRequestDataModel
import dev.proedva.androidassessmenteai.feature_operators.data.responsemodel.OperatorResponse

interface OperatorsRepository {
    suspend fun getOperators(operationsRequestDataModel: OperationsRequestDataModel) : Resource<OperatorResponse>
}