package com.example.androidprojecthomework.domain.auth

import com.example.androidprojecthomework.presentation.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
    ) {

    fun loginUser(userName: String, userPassword: String){
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreds(): UserModel{
        return authRepository.showUserCreds()
    }

    fun checkUserExists(): Boolean{
        return authRepository.doesUserExists()
    }

    fun logoutUser(){
        authRepository.userLogout()
    }
}