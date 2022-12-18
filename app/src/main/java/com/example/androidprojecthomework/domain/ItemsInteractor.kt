package com.example.androidprojecthomework.domain

import com.example.androidprojecthomework.model.ItemsModel
import dagger.Provides
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    fun getData():List<ItemsModel>{
       return  itemsRepository.getData()
    }
}