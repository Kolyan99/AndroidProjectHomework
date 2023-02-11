package com.example.androidprojecthomework.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.androidprojecthomework.data.auth.AuthRepositoryImpl
import com.example.androidprojecthomework.presentation.model.StringModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PeriodWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val authRepositoryImpl: AuthRepositoryImpl

): CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                Log.w("periodWorker", "getting String")
                authRepositoryImpl.getString(StringModel(14,"Vasua", "String", "Cold"))
            }
        }catch (e: Exception){
            return Result.retry()
        }
        return Result.success()
    }

    companion object{
         const val WORK_NAME = "PeriodWorker"
    }
}

