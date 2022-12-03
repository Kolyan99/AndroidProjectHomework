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
                "Ford mustang",
                "26.10.2023",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.lamborgini,
                "Lamborghini Gallardo",
                "10.9.2020",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.actonmartin,
                "Acton Martin",
                "10.04.2022",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.selbycobra,
                "Selby Cobra",
                "12.05.2019",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.maseratigranturismo,
                "Maserati Gran Turismo",
                "17.04.2020",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.ferrari,
                "Ferrari",
                "07.09.2021",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.jaguar,
                "Jaguar",
                "14.06.2022",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.ferraricalifornia,
                "Ferrari California",
                "30.08.2018",
                "Sport car"
            ),
            ItemsModel(
                R.drawable.audir8,
                "Audi r8",
                "03.02.2018",
                "Sport car"
            )
        )
        _items.value = listItems
    }

    fun getMessage() {
        _message.value = "ImageView clicked"
    }

    fun elementClicked(name: String, date: String, imageView: Int) {
        _element.value = Navigationelement(
            name = name,
            date = date,
            imageView = imageView
        )
    }
}

data class Navigationelement(
    val name: String,
    val date: String,
    val imageView: Int
)

