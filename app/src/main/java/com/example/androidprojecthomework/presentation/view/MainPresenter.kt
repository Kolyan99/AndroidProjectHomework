package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.domain.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists (){
        val doesUserExist = authInteractor.checkUserExsist()
        mainView.userExistsResult(doesUserExist)
    }
}