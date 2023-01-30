package com.example.androidprojecthomework.presentation.view.view

import com.example.androidprojecthomework.presentation.model.FavoritesModel

interface FavoritesView {

    fun favReceived(list: List<FavoritesModel>)
}