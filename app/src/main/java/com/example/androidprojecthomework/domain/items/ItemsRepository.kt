package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

     fun getData() : Completable

     fun showData(): Observable<List<ItemsModel>>

    suspend fun findItemsEntityById(id: Int): ItemsModel

    suspend fun favClicked(itemsModel: ItemsModel, isFavorite: Boolean)

    suspend fun getFavorites(): Flow<List<FavoritesModel>>

    suspend fun onDeleteItem(id: Int)

    suspend fun onDeleteFavorite(id: Int)
}