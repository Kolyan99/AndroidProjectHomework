package com.example.androidprojecthomework.presentation.view.view

import android.util.Log
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import javax.inject.Inject

class DescriptionPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var descriptionView: DescriptionView

    fun setView(descriptionFragment: DescriptionFragment) {
        descriptionView = descriptionFragment
    }


    fun getArguments(name: String?, date: String?, imageView: Int) {
        descriptionView.displayItemData(
            when (name.isNullOrEmpty()) {
                true -> " No Name "
                false -> name
            },
            when (date.isNullOrEmpty()) {
                true -> "No Date"
                false -> date
            },
            imageView
        )
    }

    fun logoutUser() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        CoroutineScope(Dispatchers.Main).launch(coroutineExceptionHandler) {
            val job = launch {
                try {
                    authInteractor.logoutUser()
                    descriptionView.userLoggedOut(R.navigation.auth_graph)
                }catch (e: Exception){
                    Log.w("exception", "No logout user")
                }
            }
            job.join()
            job.cancel()
        }
    }
}