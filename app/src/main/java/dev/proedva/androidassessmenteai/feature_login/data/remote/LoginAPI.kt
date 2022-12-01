package dev.proedva.androidassessmenteai.feature_login.data.remote

import dev.proedva.androidassessmenteai.feature_login.domain.model.Customer
import dev.proedva.androidassessmenteai.request_data_models.LoginRequestData
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("airoceanos-api/customer/login")
  suspend fun requestLogin(@Body loginRequestData: LoginRequestData) : Customer
}