package com.example.androidprojecthomework.domain

import com.example.androidprojecthomework.presentation.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>
}