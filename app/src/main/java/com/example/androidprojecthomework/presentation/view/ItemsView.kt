package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.presentation.model.ItemsModel

interface ItemsView {

    fun itemsReceived(list: List<ItemsModel>)

    fun imageViewClick(msg: Int)

    fun itemsClicked(navigationData: NavigateWithBundel)
}