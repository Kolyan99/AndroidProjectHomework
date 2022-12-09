package com.example.androidprojecthomework.domain

import com.example.androidprojecthomework.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>
}