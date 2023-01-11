package com.example.androidprojecthomework.data

import com.example.androidprojecthomework.data.sharedprefs.SharedPrefersHelp
import com.example.androidprojecthomework.domain.auth.AuthRepository
import com.example.androidprojecthomework.presentation.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPrefersHelp: SharedPrefersHelp
): AuthRepository {

    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO){
            sharedPrefersHelp.saveUserName(userName)
            sharedPrefersHelp.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {
       return withContext(Dispatchers.IO){
             sharedPrefersHelp.getUserCreds()
        }
    }

    override suspend fun doesUserExists(): Boolean {
      return  withContext(Dispatchers.IO){
             sharedPrefersHelp.checkUserExists()
        }

    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO){
            sharedPrefersHelp.removeUser()
        }
    }
}
