package com.example.androidprojecthomework.presentation.view

import android.util.Log
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }


     fun checkUserExists (){
         val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
             Log.w("exception", exception)
         }
         CoroutineScope(Dispatchers.Main).launch(coroutineExceptionHandler) {
             val job = launch {
                 try {
                     val doesUserExist = authInteractor.checkUserExsist()
                     mainView.userExistsResult(doesUserExist)
                 }catch (e: Exception){
                     Log.w("exception", "checkUser" )
                 }
             }
             job.join()
             job.cancel()
         }
    }
}