package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.items.ItemsInteractor
import javax.inject.Inject


class ItemsPresenter @Inject constructor( private val itemsInteractor: ItemsInteractor) {

    private lateinit var  itemsView: ItemsView



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