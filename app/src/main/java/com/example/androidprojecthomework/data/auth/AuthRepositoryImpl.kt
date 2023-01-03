package com.example.androidprojecthomework.data.auth

import com.example.androidprojecthomework.data.sharedpref.SharedPreferencesHelper
import com.example.androidprojecthomework.domain.auth.AuthRepository
import com.example.androidprojecthomework.presentation.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {
    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)

    }

    override fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()

    }

    override fun doesUserExists(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }
}