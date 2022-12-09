package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.ItemsInteractor
import com.example.androidprojecthomework.model.ItemsModel

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor
    ) {

    fun getData(){

        val listItems = itemsInteractor.getData()
        itemsView.dataReceived(listItems)
    }

    fun imageViewClick(){
        itemsView.imageClick(R.string.image_click)

    }

    fun elementSelected(name: Int, date: Int, imageView: Int){
        itemsView.goToDescription(name, date, imageView)

    }
}