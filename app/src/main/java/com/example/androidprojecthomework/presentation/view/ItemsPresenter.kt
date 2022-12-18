package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.ItemsInteractor
import com.example.androidprojecthomework.model.ItemsModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@HiltViewModel
class ItemsPresenter @Inject constructor(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor
    ) {


    @Provides
    @Singleton
    fun getData(){

        val listItems = itemsInteractor.getData()
        itemsView.dataReceived(listItems)
    }

    @Provides
    fun imageViewClick(){
        itemsView.imageClick(R.string.image_click)

    }

    @Provides
    fun elementSelected(name: Int, date: Int, imageView: Int){
        itemsView.goToDescription(name, date, imageView)

    }
}