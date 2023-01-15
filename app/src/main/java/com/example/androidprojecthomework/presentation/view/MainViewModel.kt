package com.example.androidprojecthomework.presentation.view

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
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _userExists = MutableLiveData<Int>()
    val userExists: LiveData<Int> = _userExists

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun checkUserExists() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                val doesUserExsist = authInteractor.checkUserExists()
                _userExists.value = when (doesUserExsist) {
                    true -> R.navigation.main_graph
                    false -> R.navigation.auth_graph
                }
            } catch (e: Exception) {
                _msg.value = e.message.toString()
            }
        }
    }
}