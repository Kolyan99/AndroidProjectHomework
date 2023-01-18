package com.example.androidprojecthomework.presentation.view.auth

import com.example.androidprojecthomework.R
import javax.inject.Inject

class HomePresenter @Inject constructor() {

    private lateinit var homeView: HomeView

    fun setView(homeFragment: HomeFragment){
        homeView = homeFragment
    }

    fun goItems(){
        homeView.goItems(R.navigation.main_graph)
    }


}