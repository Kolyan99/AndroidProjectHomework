package com.example.androidprojecthomework.domain.auth

import com.example.androidprojecthomework.presentation.model.StringModel
import com.example.androidprojecthomework.presentation.model.UserModel

interface AuthRepository {

   suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExists(): Boolean

    suspend fun userLogout()

    suspend fun getString(stringModel: StringModel)

    suspend fun showString(): List<StringModel>
}
