package dev.proedva.androidassessmenteai.feature_bookings.domain.repository

import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.request_data_models.AddCustomerDataModel
import dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel.AddCustomerOrderResponse
import dev.proedva.androidassessmenteai.request_data_models.OrderRequestDataModel
import dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel.OrderResponse

interface OrderRepository {
    suspend fun getOrderList(orderRequestDataModel: OrderRequestDataModel) : Resource<OrderResponse>
    suspend fun addCustomerOrder(addCustomerDataModel : AddCustomerDataModel) : Resource<AddCustomerOrderResponse>
}