package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageClick(msg: Int)

    fun goToDescription(name: Int, date: Int, imageView: Int)
}