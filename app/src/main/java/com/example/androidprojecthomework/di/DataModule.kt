package com.example.androidprojecthomework.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidprojecthomework.data.auth.AuthRepositoryImpl
import com.example.androidprojecthomework.data.items.ItemsRepositoryImp
import com.example.androidprojecthomework.data.sharedpref.SharedPreferencesHelper
import com.example.androidprojecthomework.domain.auth.AuthRepository
import com.example.androidprojecthomework.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
   abstract fun bingItemsRepository(
       itemsRepositoryImp: ItemsRepositoryImp
   ): ItemsRepository

    @Binds
    abstract fun bingAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    companion object{
        private const val Sp_Key = "Sp_Key"

        @Provides
        fun provideSharedPreferences(
            @ApplicationContext context: Context
        ): SharedPreferencesHelper{
            return SharedPreferencesHelper(
                context.getSharedPreferences(Sp_Key, MODE_PRIVATE)

            )
        }
    }
}