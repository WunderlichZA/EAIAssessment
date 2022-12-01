package dev.proedva.androidassessmenteai.feature_login.data.repository

import android.util.Log
import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.feature_login.data.remote.LoginAPI
import dev.proedva.androidassessmenteai.feature_login.domain.repository.LoginRepository
import dev.proedva.androidassessmenteai.feature_login.domain.model.Customer
import dev.proedva.androidassessmenteai.request_data_models.LoginRequestData
import java.lang.Exception
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val api: LoginAPI) : LoginRepository {
    override suspend fun requestLogin(loginRequestData: LoginRequestData): Resource<Customer> {
        return try {
            val response = api.requestLogin(loginRequestData)
            Log.e("LoginRepositoryImpl", "requestLogin: $loginRequestData")
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