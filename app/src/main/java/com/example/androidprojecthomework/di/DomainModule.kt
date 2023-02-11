package com.example.androidprojecthomework.di

import com.example.androidprojecthomework.domain.auth.AuthInteractor
import com.example.androidprojecthomework.domain.auth.AuthRepository
import com.example.androidprojecthomework.domain.items.ItemsInteractor
import com.example.androidprojecthomework.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides


@Module
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }
}
