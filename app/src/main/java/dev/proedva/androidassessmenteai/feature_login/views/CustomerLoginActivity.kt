package dev.proedva.androidassessmenteai.feature_login.views

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.proedva.androidassessmenteai.databinding.ActivityCustomerLoginBinding
import dev.proedva.androidassessmenteai.feature_login.viewmodel.LoginViewModel
import dev.proedva.androidassessmenteai.views.HomeBottomNavigation

@AndroidEntryPoint
class CustomerLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCustomerLoginBinding
    private val loginViewModel : LoginViewModel by viewModels()
    private lateinit var dataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            if(binding.editTextUsername.text?.isEmpty() == true){
                binding.usernameTextInputLayout.error = "Invalid Username"
                return@setOnClickListener
            }

            if(binding.editTextPassword.text?.isEmpty() == true){
                binding.passwordTextInputLayout.error = "Invalid Password"
                return@setOnClickListener
            }
            loginViewModel.requestLogin(binding.editTextUsername.text.toString(), binding.editTextPassword.text.toString())
        }

        lifecycleScope.launchWhenStarted {
            loginViewModel.login.collect{ event ->
                when(event){
                    is LoginViewModel.LoginEvent.Success -> {
                        binding.progressBar.isVisible = false
                        val customer = event.customerDetails
                        val intent = Intent(this@CustomerLoginActivity, HomeBottomNavigation::class.java)
                        intent.putExtra("customerObject", customer as Parcelable)
                        startActivity(intent)
                    }
                    is LoginViewModel.LoginEvent.Failure -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(this@CustomerLoginActivity, event.errorText.toString(), Toast.LENGTH_LONG).show()
                        Log.e("CustomerLoginActivi", "onCreate: ${event.errorText.toString()}")
                    }
                    is LoginViewModel.LoginEvent.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    else -> Unit
                }
            }
        }
    }
}