package com.example.androidprojecthomework.di

import android.content.Context
import com.example.androidprojecthomework.data.database.dao.ItemsDAO
import com.example.androidprojecthomework.data.database.dao.ItemsDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun itemsDatabase(context: Context):ItemsDatabase{
        return ItemsDatabase.getItemsDatabaseInstance(context)

    }
    @Provides
    fun provideItemsDao(itemsDatabase: ItemsDatabase): ItemsDAO{
        return itemsDatabase.getItemsDao()
    }
}