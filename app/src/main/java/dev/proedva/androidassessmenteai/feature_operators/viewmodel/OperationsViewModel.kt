package dev.proedva.androidassessmenteai.feature_operators.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.proedva.androidassessmenteai.core.DispatcherProvider
import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.feature_operators.domain.repository.OperatorsRepository
import dev.proedva.androidassessmenteai.request_data_models.OperationsRequestDataModel
import dev.proedva.androidassessmenteai.feature_operators.domain.model.Operator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OperationsViewModel @Inject constructor(
    private val repository: OperatorsRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    sealed class OperatorsEvent{
        class Success (val operators : List<Operator>) : OperatorsEvent()
        class Failure(val errorText : String?) : OperatorsEvent()
        object Loading : OperatorsEvent()
        object Empty : OperatorsEvent()
    }

    private val _operator = MutableStateFlow<OperatorsEvent>(OperatorsEvent.Empty)
    val operator : StateFlow<OperatorsEvent> = _operator

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getOperators(customerId : String){
        val operationsRequestDataModel = OperationsRequestDataModel(customerId)

        viewModelScope.launch(dispatchers.io) {
            _operator.value = OperatorsEvent.Loading
            when(val operatorsResponse = repository.getOperators(operationsRequestDataModel)){
                is Resource.Error -> _operator.value =
                    OperatorsEvent.Failure(operatorsResponse.message)
                is Resource.Success -> {
                    val operatorList = operatorsResponse.data?.operatorList
                    if(operatorList != null)
                        _operator.value = OperatorsEvent.Success(operatorList)
                }
            }
        }
    }
}