package dev.proedva.androidassessmenteai.feature_operators.data.repository

import android.util.Log
import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.feature_operators.data.remote.OperatorAPI
import dev.proedva.androidassessmenteai.feature_operators.domain.repository.OperatorsRepository
import dev.proedva.androidassessmenteai.request_data_models.OperationsRequestDataModel
import dev.proedva.androidassessmenteai.feature_operators.data.responsemodel.OperatorResponse
import java.lang.Exception
import javax.inject.Inject

class OperatorsRepositoryImpl @Inject constructor(private val operatorAPI: OperatorAPI) :
    OperatorsRepository {
    override suspend fun getOperators(operationsRequestDataModel: OperationsRequestDataModel): Resource<OperatorResponse> {
        return try {
            val response = operatorAPI.getOperators(operationsRequestDataModel)
            Log.e("LoginRepositoryImpl", "requestLogin: $operationsRequestDataModel")
            if(response.valid){
                Resource.Success(response)
            }else{
                Log.e("RepositoryImpl", "requestLogin: ${response.message}")
                Resource.Error(response.message)
            }
        }catch (e: Exception){
            Resource.Error(e.message ?: "An unexpected error has occured")
        }
    }
}