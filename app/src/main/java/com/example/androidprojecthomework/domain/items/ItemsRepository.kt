package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>
}