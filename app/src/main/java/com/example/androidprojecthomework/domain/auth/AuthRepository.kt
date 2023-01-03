package com.example.androidprojecthomework.domain.auth

import com.example.androidprojecthomework.presentation.model.UserModel

interface AuthRepository {

    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds(): UserModel

    fun doesUserExists(): Boolean

    fun userLogout()
}