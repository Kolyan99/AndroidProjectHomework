package com.example.androidprojecthomework.presentation.view.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<NavToHome?>()
    val nav: LiveData<NavToHome?> = _nav

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg


    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                authInteractor.loginUser(userName, userPassword)
                _nav.value = NavToHome(
                    R.id.action_loginFragment_to_homeFragment,
                    R.id.loginFragment
                )
            } catch (e: Exception) {
                _msg.value = e.message.toString()
            }
        }
    }
}

data class NavToHome(
    val destinationId: Int,
    val removeFragment: Int
)

