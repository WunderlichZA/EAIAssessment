package dev.proedva.androidassessmenteai.feature_bookings.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.proedva.androidassessmenteai.core.DispatcherProvider
import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.feature_bookings.data.responsemodel.AddCustomerOrderResponse
import dev.proedva.androidassessmenteai.feature_bookings.domain.model.OrderItem
import dev.proedva.androidassessmenteai.feature_bookings.domain.repository.OrderRepository
import dev.proedva.androidassessmenteai.request_data_models.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingsViewModel @Inject constructor(
    private val repository: OrderRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    sealed class BookingsEvent{
        class Success (val bookingList : List<OrderItem>) : BookingsEvent()
        class AddBookingSuccess(val bookingResult : AddCustomerOrderResponse) : BookingsEvent()
        class Failure(val errorText : String?) : BookingsEvent()
        object Loading : BookingsEvent()
        object Empty : BookingsEvent()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _bookings = MutableStateFlow<BookingsEvent>(BookingsEvent.Empty)
    val bookings : StateFlow<BookingsEvent> = _bookings

    fun getBookings(){
        val orderRequestDataModel = OrderRequestDataModel("customerId", "status")
        viewModelScope.launch {
            _bookings.value = BookingsEvent.Loading
            when(val bookingResponse = repository.getOrderList(orderRequestDataModel)){
                is Resource.Error -> _bookings.value =
                    BookingsEvent.Failure(bookingResponse.message)
                is Resource.Success -> {
                    val bookingList = bookingResponse.data?.orderItemList
                    if(bookingList != null){
                        _bookings.value = BookingsEvent.Success(bookingList)
                    }
                }
            }
        }
    }

    fun addCustomerBooking(addCustomerDataModel: AddCustomerDataModel){
        viewModelScope.launch {
            _bookings.value = BookingsEvent.Loading
            when(val bookingResponse = repository.addCustomerOrder(addCustomerDataModel)){
                is Resource.Error -> _bookings.value =
                    BookingsEvent.Failure(bookingResponse.data?.message)
                is Resource.Success -> {
                    val bookingResult = bookingResponse.data
                    if(bookingResult != null)
                        _bookings.value = BookingsEvent.AddBookingSuccess(bookingResult)
                }
            }
        }
    }
}