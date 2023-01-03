package com.example.androidprojecthomework.di

import com.example.androidprojecthomework.domain.items.ItemsInteractor
import com.example.androidprojecthomework.presentation.view.ItemsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    fun provideItemsPresenter(
        itemsInteractor: ItemsInteractor
    ): ItemsPresenter{
        return ItemsPresenter(itemsInteractor)
    }
}