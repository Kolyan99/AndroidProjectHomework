package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter  @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {

    private lateinit var itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsFragment
    }

    fun getItems(){
        val items = itemsInteractor.getData()
        itemsView.itemsReceived(items)
    }

    fun imageViewClicked(){
        itemsView.imageViewClick(R.string.image_click)

    }

    fun itemClicked(name: Int, date: Int, imageView: Int){
        itemsView.itemsClicked(NavigateWithBundel(name,date,imageView))
    }
}

data class NavigateWithBundel(
    val name: Int,
    val date: Int,
    val imageView: Int
)
