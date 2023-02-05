package com.example.androidprojecthomework.presentation.view.auth

import com.example.androidprojecthomework.presentation.model.StringModel

interface HomeView {

    fun goItems(destination: Int)

    fun showString(string: List<StringModel>)
}