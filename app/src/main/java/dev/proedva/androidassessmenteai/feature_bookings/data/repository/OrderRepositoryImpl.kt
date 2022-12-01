package dev.proedva.androidassessmenteai.feature_bookings.data.repository

import android.util.Log
import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.feature_bookings.data.remote.OrderAPI
import dev.proedva.androidassessmenteai.feature_bookings.domain.repository.OrderRepository
import dev.proedva.androidassessmenteai.request_data_models.AddCustomerDataModel
import dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel.AddCustomerOrderResponse
import dev.proedva.androidassessmenteai.request_data_models.OrderRequestDataModel
import dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel.OrderResponse
import javax.inject.Inject
import kotlin.Exception

class OrderRepositoryImpl @Inject constructor(private val api: OrderAPI) : OrderRepository {
    override suspend fun getOrderList(orderRequestDataModel: OrderRequestDataModel): Resource<OrderResponse> {
        return try {
            val response = api.getOrderList(orderRequestDataModel)
            Log.e("LoginRepositoryImpl", "requestLogin: $orderRequestDataModel")
            if (response.valid) {
                Resource.Success(response)
            } else {
                Log.e("RepositoryImpl", "requestLogin: ${response.message}")
                Resource.Error(response.message)
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unexpected error has occured.")
        }
    }

    override suspend fun addCustomerOrder(addCustomerDataModel: AddCustomerDataModel): Resource<AddCustomerOrderResponse> {
        return try {
            val response = api.addCustomerOrder(addCustomerDataModel)
            if (response.valid)
                Resource.Success(response)
            else
                Resource.Error(response.message)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unexpected error has occured.")
        }
    }
}