package com.example.androidprojecthomework.domain.items

import com.example.androidprojecthomework.presentation.model.ItemsModel

interface ItemsRepository {

  suspend  fun getData(): List<ItemsModel>
}