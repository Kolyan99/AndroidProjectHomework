package com.example.androidprojecthomework.presentation.view.auth

import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val authInteractor: AuthInteractor,
) {

    private lateinit var homeView: HomeView

    fun setView(homeFragment: HomeFragment){
        this.homeView = homeFragment
    }

    fun goItems(){
        homeView.goItems(R.navigation.main_graph)
    }


}