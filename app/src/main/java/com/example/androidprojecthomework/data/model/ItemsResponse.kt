package com.example.androidprojecthomework.data.model

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    val id: Int,
    @SerializedName("name")
    val personName: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

data class Company(
    @SerializedName("name")
    val companyName: String,
    val catchPhrase: String,
    val bs: String
)

data class Geo(
    val lat: String,
    val lng: String
)


