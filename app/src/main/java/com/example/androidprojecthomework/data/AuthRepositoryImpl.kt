package com.example.androidprojecthomework.data

import com.example.androidprojecthomework.data.sharedprefs.SharedPrefersHelp
import com.example.androidprojecthomework.domain.AuthRepository
import com.example.androidprojecthomework.presentation.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPrefersHelp: SharedPrefersHelp
): AuthRepository {

    override fun loginUser(userName: String, userPassword: String) {
        sharedPrefersHelp.saveUserName(userName)
        sharedPrefersHelp.saveUserPassword(userPassword)

    }

    override fun showUserCreds(): UserModel {
        return sharedPrefersHelp.getUserCreds()
    }

    override fun doesUserExists(): Boolean {
        return sharedPrefersHelp.checkUserExists()
    }

    override fun userLogout() {
        sharedPrefersHelp.removeUser()
    }
}
