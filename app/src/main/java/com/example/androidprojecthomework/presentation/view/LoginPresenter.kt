package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.domain.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment){
        loginView = loginFragment

    }

    fun loginUser(userName: String, userPassword: String){
        authInteractor.loginUser(userName, userPassword)
        loginView.userLogged()
    }
}