package com.example.androidprojecthomework.domain.items

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
}