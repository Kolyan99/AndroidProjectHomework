package com.example.androidprojecthomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidprojecthomework.model.ItemsModel

class ItemsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _element = MutableLiveData<Navigationelement>()
    val element: LiveData<Navigationelement> = _element

    fun getList() {

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
        _items.value = listItems
    }

    fun getMessage() {
        _message.value = "ImageView clicked"
    }

    fun elementClicked(name: Int, date: Int, imageView: Int) {
        _element.value = Navigationelement(
            name = name,
            date = date,
            imageView = imageView
        )
    }
}

data class Navigationelement(
    val name: Int,
    val date: Int,
    val imageView: Int
)

