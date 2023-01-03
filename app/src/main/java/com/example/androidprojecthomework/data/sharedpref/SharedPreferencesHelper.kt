package com.example.androidprojecthomework.data.sharedpref

import android.content.SharedPreferences
import com.example.androidprojecthomework.presentation.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreference: SharedPreferences
) {

    fun saveUserName(name: String?){
        sharedPreference.edit().putString(User_Name, name).apply()
    }

    fun saveUserPassword(password: String?){
        sharedPreference.edit().putString(User_Password, password).apply()
    }

    fun getUserCreds(): UserModel{
        val name = sharedPreference.getString(User_Name, "") ?: "No user"
        val password = sharedPreference.getString(User_Password, "") ?: "No password"
        return UserModel(name,password)

    }

    fun checkUserExists(): Boolean{
        val name = sharedPreference.getString(User_Name, "")
        val password = sharedPreference.getString(User_Password, "")
        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())
    }

    fun removeUser(){
        saveUserName(null)
        saveUserPassword(null)
    }

    companion object{
        private const val User_Name = "User Name"
        private const val User_Password = "User Password"
    }
}