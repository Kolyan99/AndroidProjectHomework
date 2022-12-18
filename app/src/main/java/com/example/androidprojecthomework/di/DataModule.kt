package com.example.androidprojecthomework.di

import com.example.androidprojecthomework.data.ItemsRepositoryImp
import com.example.androidprojecthomework.domain.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
   abstract fun bingItemsRepository(
       itemsRepositoryImp: ItemsRepositoryImp
   ): ItemsRepository
}