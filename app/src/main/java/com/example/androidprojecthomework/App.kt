package com.example.androidprojecthomework

import android.app.Application

import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.androidprojecthomework.data.worker.PeriodWorker
import com.example.androidprojecthomework.di.AppModule
import com.example.androidprojecthomework.di.component.AppComponent
import com.example.androidprojecthomework.di.component.DaggerAppComponent
import dagger.Component
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class App: Application(){

    lateinit var appComponent: AppComponent

    fun provideAppComponent(): AppComponent{
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }
}
