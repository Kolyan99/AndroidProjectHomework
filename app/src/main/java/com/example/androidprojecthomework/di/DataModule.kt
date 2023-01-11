package com.example.androidprojecthomework.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidprojecthomework.data.AuthRepositoryImpl
import com.example.androidprojecthomework.data.ItemsRepositoryImp
import com.example.androidprojecthomework.data.sharedprefs.SharedPrefersHelp
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
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    companion object{
        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(
            @ApplicationContext context: Context
        ): SharedPrefersHelp{
            return SharedPrefersHelp(
                context.getSharedPreferences(SP_KEY, MODE_PRIVATE)

            )
        }
    }
}
