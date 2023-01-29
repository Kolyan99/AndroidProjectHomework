package com.example.androidprojecthomework.di

import com.example.androidprojecthomework.domain.auth.AuthInteractor
import com.example.androidprojecthomework.domain.items.ItemsInteractor
import com.example.androidprojecthomework.presentation.view.view.DescriptionPresenter
import com.example.androidprojecthomework.presentation.view.view.ItemsPresenter
import com.example.androidprojecthomework.presentation.view.auth.LoginPresenter
import com.example.androidprojecthomework.presentation.view.MainPresenter
import com.example.androidprojecthomework.presentation.view.auth.HomePresenter
import com.example.androidprojecthomework.presentation.view.view.FavoritesPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideItemsPresenter(
        itemsInteractor: ItemsInteractor
    ): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }

    @Provides
    fun provideHomePresenter(authInteractor: AuthInteractor): HomePresenter {
        return HomePresenter(authInteractor)
    }

    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter{
        return MainPresenter(authInteractor)
    }

    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter {
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideDescriptionPresenter(authInteractor: AuthInteractor): DescriptionPresenter {
        return DescriptionPresenter(authInteractor)
    }

    @Provides fun provideFavoritesPresenter(itemsInteractor: ItemsInteractor): FavoritesPresenter {
        return FavoritesPresenter(itemsInteractor)
    }



}