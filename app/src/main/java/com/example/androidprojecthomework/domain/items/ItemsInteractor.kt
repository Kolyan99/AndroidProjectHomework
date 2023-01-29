package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(
    private val itemsRepository: ItemsRepository
    ) {

    suspend fun getData(){
        itemsRepository.getData()
    }

    suspend fun showData(): List<ItemsModel>{
        return itemsRepository.showData()
    }

    suspend fun findItemsEntityById(id: Int){
        itemsRepository.findItemsEntityById(id)
    }

    suspend fun onFavClicked(id: Int){
        val foundItems = itemsRepository.findItemsEntityById(id)
        itemsRepository.favClicked(foundItems)
    }

    suspend fun getFavorites(): List<FavoritesModel>{
        return itemsRepository.getFavorites()
    }

}