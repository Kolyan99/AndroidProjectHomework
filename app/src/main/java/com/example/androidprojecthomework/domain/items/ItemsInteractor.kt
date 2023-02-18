package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsInteractor @Inject constructor(
    private val itemsRepository: ItemsRepository
    ) {

     fun getData(): Completable{
       return itemsRepository.getData()
    }

     fun showData(): Observable<List<ItemsModel>>{
        return itemsRepository.showData()
    }

    suspend fun findItemsEntityById(id: Int){
        itemsRepository.findItemsEntityById(id)
    }

    suspend fun onFavClicked(id: Int, isFavorite: Boolean){
        val foundItems = itemsRepository.findItemsEntityById(id)
        itemsRepository.favClicked(foundItems, isFavorite)
    }

    suspend fun getFavorites(): Flow<List<FavoritesModel>>{
        return itemsRepository.getFavorites()
    }

    suspend fun onDeleteItem(id: Int){
        itemsRepository.onDeleteItem(id)
    }

    suspend fun onDeleteFavorite(id: Int){
        itemsRepository.onDeleteFavorite(id)
    }

}