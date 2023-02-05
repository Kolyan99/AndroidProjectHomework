package com.example.androidprojecthomework.data.auth

import com.example.androidprojecthomework.data.database.dao.ItemsDAO
import com.example.androidprojecthomework.data.database.dao.StringEntity
import com.example.androidprojecthomework.data.sharedprefs.SharedPrefersHelp
import com.example.androidprojecthomework.domain.auth.AuthRepository
import com.example.androidprojecthomework.presentation.model.StringModel
import com.example.androidprojecthomework.presentation.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPrefersHelp: SharedPrefersHelp,
    private val itemsDAO: ItemsDAO
) : AuthRepository {

    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO) {
            sharedPrefersHelp.saveUserName(userName)
            sharedPrefersHelp.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {
        return withContext(Dispatchers.IO) {
            sharedPrefersHelp.getUserCreds()
        }
    }

    override suspend fun doesUserExists(): Boolean {
        return withContext(Dispatchers.IO) {
            sharedPrefersHelp.checkUserExists()
        }

    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO) {
            sharedPrefersHelp.removeUser()
        }
    }

    override suspend fun getString(stringModel: StringModel) {
        withContext(Dispatchers.IO) {
            itemsDAO.insertStringEntity(
                StringEntity(
                    stringModel.id,
                    stringModel.name,
                    stringModel.tl,
                    stringModel.cl
                )
            )
        }
    }

    override suspend fun showString(): List<StringModel> {
        return withContext(Dispatchers.IO) {
            val stringEntity = itemsDAO.getStringEntities()
            stringEntity.map {
                StringModel(
                    it.id,
                    it.name,
                    it.tl,
                    it.cl
                )
            }
        }
    }
}
