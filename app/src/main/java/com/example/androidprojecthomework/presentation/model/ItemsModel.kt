package com.example.androidprojecthomework.presentation.model

import com.example.androidprojecthomework.data.model.Address
import com.example.androidprojecthomework.data.model.Company
import com.example.androidprojecthomework.data.model.Geo
import com.google.gson.annotations.SerializedName

data class ItemsModel(
    val id: Int,
    @SerializedName("name")
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
    @SerializedName("name")
    val catchPhrase: String,
    val bs: String
)
