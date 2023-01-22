package com.example.androidprojecthomework.presentation.view.auth

import android.util.Log
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

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
        CoroutineScope(Dispatchers.Main).launch(coroutineExceptionHandler) {
            val job = launch {
                try {
                    authInteractor.loginUser(userName, userPassword)
                  //  loginView.userLogged(R.id.action_loginFragment_to_homeFragment, R.id.loginFragment)
                }catch (e: Exception){
                    Log.w("exception", "loginUser FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }
}