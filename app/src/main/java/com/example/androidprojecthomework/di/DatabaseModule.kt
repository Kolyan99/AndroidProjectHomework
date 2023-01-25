package com.example.androidprojecthomework.di

import android.content.Context
import com.example.androidprojecthomework.data.database.dao.ItemsDao
import com.example.androidprojecthomework.data.database.dao.ItemsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun itemsDatabase(context: Context):ItemsDatabase{
        return ItemsDatabase.getItemsDatabaseInstance(context)

    }

    @Provides
    fun provideItemsDao(itemsDatabase: ItemsDatabase): ItemsDao{
        return itemsDatabase.getItemsDao()
    }


}