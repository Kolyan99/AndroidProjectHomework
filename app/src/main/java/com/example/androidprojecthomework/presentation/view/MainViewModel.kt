package com.example.androidprojecthomework.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _userExists = MutableLiveData<Boolean>()
    val userExists: LiveData<Boolean> = _userExists

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun checkUserExists(){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                _userExists.value = authInteractor.checkUserExists()
            }catch (e: Exception){
                _msg.value = e.message.toString()
            }
        }
    }
}