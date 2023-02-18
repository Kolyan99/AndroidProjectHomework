package com.example.androidprojecthomework.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidprojecthomework.data.ApiService
import com.example.androidprojecthomework.data.auth.AuthRepositoryImpl
import com.example.androidprojecthomework.data.items.ItemsRepositoryImp
import com.example.androidprojecthomework.data.sharedprefs.SharedPrefersHelp
import com.example.androidprojecthomework.domain.auth.AuthRepository
import com.example.androidprojecthomework.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
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
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"

        @Provides
        fun provideSharedPreferences(
             context: Context
        ): SharedPrefersHelp{
            return SharedPrefersHelp(
                context.getSharedPreferences(SP_KEY, MODE_PRIVATE)

            )
        }

        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService{
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}
