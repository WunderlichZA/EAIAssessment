package dev.proedva.androidassessmenteai.feature_bookings.data.remote

import dev.proedva.androidassessmenteai.request_data_models.AddCustomerDataModel
import dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel.AddCustomerOrderResponse
import dev.proedva.androidassessmenteai.request_data_models.OrderRequestDataModel
import dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel.OrderResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderAPI {
    @POST("airoceanos-api/customer/order/query/list")
    suspend fun getOrderList(@Body orderRequestDataModel: OrderRequestDataModel) : OrderResponse
    @POST("airoceanos-api/customer/order/add")
    suspend fun addCustomerOrder(@Body addCustomerDataModel : AddCustomerDataModel) : AddCustomerOrderResponse
}