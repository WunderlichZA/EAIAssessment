package dev.proedva.androidassessmenteai.feature_login.domain.repository

import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.feature_login.domain.model.Customer
import dev.proedva.androidassessmenteai.request_data_models.LoginRequestData

interface LoginRepository {
    suspend fun requestLogin(loginRequestData: LoginRequestData) : Resource<Customer>
}