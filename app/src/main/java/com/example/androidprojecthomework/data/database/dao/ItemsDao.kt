package com.example.androidprojecthomework.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidprojecthomework.data.database.FavoritesEntity
import com.example.androidprojecthomework.data.database.ItemsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * FROM itemsEntity")
    fun getItemsEntities(): Flow<List<ItemsEntity>>

    @Query("SELECT(SELECT COUNT(*) FROM itemsEntity) !=0")
    fun doesItemsEntityExist(): Boolean

    @Query("SELECT * FROM itemsEntity WHERE id=:searchText ")
    fun findItemsEntityById(searchText: Int): ItemsEntity

    @Query("UPDATE itemsEntity SET isFavorite = :isFavorite WHERE id = :id ")
    fun addToFavorite(id: Int, isFavorite: Boolean)

    @Query("DELETE FROM itemsEntity WHERE id =:id")
    fun deleteItemEntityById(id: Int)

    @Insert
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity")
    fun getFavoritesEntities(): Flow<List<FavoritesEntity>>

    @Query("DELETE FROM FavoritesEntity WHERE id = :id")
    fun deleteFavoriteEntityById(id: Int)

    @Insert
    fun insertStringEntity(stringEntity: StringEntity)

    @Query("SELECT * FROM StringEntity")
    fun getStringEntities(): List<StringEntity>
}