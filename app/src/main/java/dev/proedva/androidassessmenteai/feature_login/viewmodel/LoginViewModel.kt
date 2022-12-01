package dev.proedva.androidassessmenteai.feature_login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.proedva.androidassessmenteai.core.DispatcherProvider
import dev.proedva.androidassessmenteai.core.Resource
import dev.proedva.androidassessmenteai.feature_login.domain.repository.LoginRepository
import dev.proedva.androidassessmenteai.feature_login.domain.model.Customer
import dev.proedva.androidassessmenteai.request_data_models.LoginRequestData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository,
                                         private val dispatchers: DispatcherProvider) : ViewModel() {

    sealed class LoginEvent{
        class Success (val customerDetails : Customer) : LoginEvent()
        class Failure(val errorText : String?) : LoginEvent()
        object Loading : LoginEvent()
        object Empty : LoginEvent()
    }

    private val _login = MutableStateFlow<LoginEvent>(LoginEvent.Empty)
    val login : StateFlow<LoginEvent> = _login

    fun requestLogin(username : String, password : String){
        val loginRequestData = LoginRequestData(username, password)
        Log.e("LoginViewModel", "Name: ${loginRequestData.username} Password: ${loginRequestData.password}")

        viewModelScope.launch(dispatchers.io) {
            _login.value = LoginEvent.Loading
            when(val loginResponse = repository.requestLogin(loginRequestData)){
                is Resource.Error -> _login.value = LoginEvent.Failure(loginResponse.data?.message)
                is Resource.Success -> {
                    if(loginResponse.data?.valid == true){
                        _login.value = LoginEvent.Success(loginResponse.data)
                    }
                }
            }
        }
    }
}