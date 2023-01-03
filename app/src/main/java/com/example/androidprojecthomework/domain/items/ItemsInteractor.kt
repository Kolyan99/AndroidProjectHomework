package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    fun getData():List<ItemsModel>{
       return  itemsRepository.getData()
    }
}