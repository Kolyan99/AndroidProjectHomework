package com.example.androidprojecthomework.presentation.view.home

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
class DescriptionViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun logoutUser(){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                authInteractor.logoutUser()
                _nav.value = R.navigation.auth_graph
            }catch (e: Exception){
                _msg.value = e.message.toString()
            }
        }
    }
}