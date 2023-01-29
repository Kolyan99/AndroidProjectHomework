package com.example.androidprojecthomework.presentation.view.view

import android.util.Log
import com.example.androidprojecthomework.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {

    private lateinit var favoritesView: FavoritesView

    fun setView(favoritesFragment: FavoritesFragment){
        favoritesView = favoritesFragment
    }



    fun getFavorites() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        CoroutineScope(Dispatchers.Main).launch(coroutineExceptionHandler) {
            val job = launch {
                try {
                    val favoritesItems = itemsInteractor.getFavorites()
                    favoritesView.getFavorites(favoritesItems)
                } catch (e: Exception) {
                    Log.w("Exception", " No Favorites")
                }
            }
            job.join()
            job.cancel()
        }
    }
}