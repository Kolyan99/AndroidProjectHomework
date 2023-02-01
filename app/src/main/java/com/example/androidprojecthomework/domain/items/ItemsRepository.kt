package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

    suspend fun getData()

    suspend fun showData(): Flow<List<ItemsModel>>

    suspend fun findItemsEntityById(id: Int): ItemsModel

    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun getFavorites(): Flow<List<FavoritesModel>>

    suspend fun onDeleteItem(id: Int)

    suspend fun onDeleteFavorite(id: Int)
}