package com.example.androidprojecthomework.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.domain.items.ItemsInteractor
import com.example.androidprojecthomework.presentation.model.ItemsModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor,
) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message


    fun getData() {
        val coroutinesExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        viewModelScope.launch(coroutinesExceptionHandler) {
            try {
                val listItems = itemsInteractor.getData()
                _items.value = listItems
            }catch (e: Exception){
                _message.value = e.message.toString()
            }
        }
    }

    fun imageViewClicked() {
        _msg.value = R.string.click
    }

    fun elementClicked(name: Int, date: Int, image: Int,) {
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = image,

        )
    }

    fun userNavigated() {
        _bundle.value = null
    }
}

data class NavigateWithBundle(
    val name: Int,
    val date: Int,
    val image: Int,

)
