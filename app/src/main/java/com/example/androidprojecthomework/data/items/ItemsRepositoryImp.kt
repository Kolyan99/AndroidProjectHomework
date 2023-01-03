package com.example.androidprojecthomework.data.items

import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.items.ItemsRepository
import com.example.androidprojecthomework.presentation.model.ItemsModel
import javax.inject.Inject

class ItemsRepositoryImp @Inject constructor(): ItemsRepository {

    override fun getData(): List<ItemsModel> {
        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.ford,
                R.string.car,
                R.string.data,
                R.string.type
            ),
            ItemsModel(
                R.drawable.lamborgini,
                R.string.car1,
                R.string.data1,
                R.string.type1
            ),
            ItemsModel(
                R.drawable.actonmartin,
                R.string.car2,
                R.string.data2,
                R.string.type2
            ),
            ItemsModel(
                R.drawable.selbycobra,
                R.string.car3,
                R.string.data3,
                R.string.type3
            ),
            ItemsModel(
                R.drawable.maseratigranturismo,
                R.string.car4,
                R.string.data4,
                R.string.type4
            ),
            ItemsModel(
                R.drawable.ferrari,
                R.string.car5,
                R.string.data5,
                R.string.type5
            ),
            ItemsModel(
                R.drawable.jaguar,
                R.string.car6,
                R.string.data6,
                R.string.type6
            ),
            ItemsModel(
                R.drawable.ferraricalifornia,
                R.string.car7,
                R.string.data7,
                R.string.type7
            ),
            ItemsModel(
                R.drawable.audir8,
                R.string.car8,
                R.string.data8,
                R.string.type8
            )
        )
        return listItems
    }
}