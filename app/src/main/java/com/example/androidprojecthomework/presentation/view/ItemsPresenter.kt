package com.example.androidprojecthomework.presentation.view

import android.util.Log
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemsPresenter  @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {

    private lateinit var itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsFragment
    }

    fun getItems(){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler){
            val job = launch {
                try {
                    val items = itemsInteractor.getData()
                    itemsView.itemsReceived(items)
                }catch (e: Exception){
                    Log.w("exception", "No cars")
                }
            }
            job.join()
            job.cancel()
        }

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
