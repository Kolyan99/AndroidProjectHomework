package com.example.androidprojecthomework.presentation.view

import android.util.Log
import android.widget.Toast
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Scope

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment){
        loginView = loginFragment
    }


    fun loginUser(userName: String, userPassword: String){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler) {
            val job = launch {
                try {
                    authInteractor.loginUser(userName, userPassword)
                    loginView.userLogged()
                }catch (e: Exception){
                    Log.w("exception", "loginUser FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }
}