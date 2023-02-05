package com.example.androidprojecthomework.domain.auth

import com.example.androidprojecthomework.presentation.model.StringModel
import com.example.androidprojecthomework.presentation.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend fun loginUser(userName: String, userPassword: String){
        authRepository.loginUser(userName, userPassword)
    }

     suspend fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    suspend fun checkUserExsist(): Boolean{
        return authRepository.doesUserExists()
    }

    suspend fun logoutUser(){
        authRepository.userLogout()
    }

    suspend fun getString(): List<StringModel>{
        return authRepository.showString()
    }

    suspend fun showString(): List<StringModel>{
        return authRepository.showString()
    }
}
