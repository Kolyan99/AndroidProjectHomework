package com.example.androidprojecthomework.data.auth

import com.example.androidprojecthomework.data.sharedpref.SharedPreferencesHelper
import com.example.androidprojecthomework.domain.auth.AuthRepository
import com.example.androidprojecthomework.presentation.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {
    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {
       return withContext(Dispatchers.IO){
             sharedPreferencesHelper.getUserCreds()
        }
    }

    override suspend fun doesUserExists(): Boolean {
       return withContext(Dispatchers.IO){
            sharedPreferencesHelper.checkUserExists()
        }
    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.removeUser()
        }
    }
}