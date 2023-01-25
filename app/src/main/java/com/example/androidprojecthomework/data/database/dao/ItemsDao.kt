package com.example.androidprojecthomework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidprojecthomework.data.database.ItemsEntity

@Dao
interface ItemsDao {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * FROM ItemsEntity")
    fun getItemsEntity(): List<ItemsEntity>

    @Query("SELECT(SELECT COUNT(*) FROM ItemsEntity) !=0")
    fun doesItemsEntityExists(): Boolean
}