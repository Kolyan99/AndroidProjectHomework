package com.example.androidprojecthomework.di

import com.example.androidprojecthomework.domain.AuthInteractor
import com.example.androidprojecthomework.domain.AuthRepository
import com.example.androidprojecthomework.domain.ItemsInteractor
import com.example.androidprojecthomework.domain.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor{
        return ItemsInteractor(itemsRepository)
    }

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor{
        return AuthInteractor(authRepository)
    }
}
