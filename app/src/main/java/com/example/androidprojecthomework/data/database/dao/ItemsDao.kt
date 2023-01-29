package com.example.androidprojecthomework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidprojecthomework.data.database.FavoritesEntity
import com.example.androidprojecthomework.data.database.ItemsEntity

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * FROM itemsEntity")
    fun getItemsEntities(): List<ItemsEntity>

    @Query("SELECT(SELECT COUNT(*) FROM itemsEntity) !=0")
    fun doesItemsEntityExist(): Boolean

    @Query("SELECT * FROM itemsEntity WHERE id=:searchText ")
    fun findItemsEntityById(searchText: Int): ItemsEntity


    @Insert
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity")
    fun getFavoritesEntities(): List<FavoritesEntity>
}