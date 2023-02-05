package com.example.androidprojecthomework.presentation.view.auth

import android.util.Log
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val authInteractor: AuthInteractor,
) {

    private lateinit var homeView: HomeView

    fun setView(homeFragment: HomeFragment) {
        this.homeView = homeFragment
    }

    fun goItems() {
        homeView.goItems(R.navigation.main_graph)
    }

    fun getString() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        CoroutineScope(Dispatchers.Main).launch(coroutineExceptionHandler) {
            val job = launch {
                try {
                    val stringModel = authInteractor.getString()
                    homeView.showString(stringModel)

                } catch (e: Exception) {
                    Log.w("exception", "No cars")
                }
            }
            job.join()
            job.cancel()
        }

    }
}
