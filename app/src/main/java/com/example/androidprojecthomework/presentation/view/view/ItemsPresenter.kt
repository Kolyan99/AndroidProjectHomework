package com.example.androidprojecthomework.presentation.view.view

import android.util.Log
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.data.model.Address
import com.example.androidprojecthomework.data.model.Company
import com.example.androidprojecthomework.data.model.Geo
import com.example.androidprojecthomework.domain.items.ItemsInteractor
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemsPresenter  @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {

    private lateinit var itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsFragment
    }

    fun getItems(){

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exception", exception)
        }
        CoroutineScope(Dispatchers.Main).launch(coroutineExceptionHandler){
            val job = launch {
                try {
                    val items = itemsInteractor.getData()
                    itemsView.itemsReceived(items)
                }catch (e: Exception){
                    Log.w("exception", "No cars")
                }
            }
            job.join()
            job.cancel()
        }

    }

    fun imageViewClicked(){
        itemsView.imageViewClick(R.string.image_click)

    }

    fun itemClicked(
        id: Int,
        username: String,
        email: String,
        website: String,
        phone: String,
        address: Address,
        geo: Geo,
        company: Company,
        street: String,
        suite: String,
        city: String,
        zipcode: String,
        lat: String,
        lng: String,
        catchPhrase: String,
        bs: String){
        itemsView.itemsClicked(NavigateWithBundel(id, username, email, website, phone, address, geo, company, street, suite, city, zipcode, lat, lng, catchPhrase, bs)
            , R.id.action_itemsFragment_to_descriptionFragment)
    }
}

data class NavigateWithBundel(
    val id: Int,
    val username: String,
    val email: String,
    val website: String,
    val phone: String,
    val address: Address,
    val geo: Geo,
    val company: Company,
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val lat: String,
    val lng: String,
    val catchPhrase: String,
    val bs: String
)
