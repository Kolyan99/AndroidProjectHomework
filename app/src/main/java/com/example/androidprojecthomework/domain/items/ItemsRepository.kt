package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel

interface ItemsRepository {

    suspend fun getData()

    suspend fun showData(): List<ItemsModel>

    suspend fun findItemsEntityById(id: Int): ItemsModel

    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun getFavorites(): List<FavoritesModel>
}