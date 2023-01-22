package com.example.androidprojecthomework.data.model

data class ItemsResponse(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val website: String,
    val phone: String,
    val address: Address,
    val geo: Geo,
    val company: Company
)
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String
)
data class Geo(
    val lat: String,
    val lng: String
)

data class Company (
    val catchPhrase: String,
    val bs: String
)

