package com.example.androidprojecthomework.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidprojecthomework.data.database.FavoritesEntity
import com.example.androidprojecthomework.data.database.ItemsEntity

@Database(entities = [ItemsEntity::class, FavoritesEntity::class], version = 1, exportSchema = false)
abstract class ItemsDatabase: RoomDatabase() {

    abstract fun getItemsDao(): ItemsDAO

    companion object{
        private const val DATABASE_NAME = "Items_DB"
        private var DB_INSTANSE: ItemsDatabase? = null

        fun getItemsDatabaseInstance(context: Context): ItemsDatabase{
            return DB_INSTANSE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { DB_INSTANSE = it }
        }
    }
}