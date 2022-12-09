package com.example.androidprojecthomework.domain

import com.example.androidprojecthomework.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getData():List<ItemsModel>{
       return  itemsRepository.getData()
    }
}