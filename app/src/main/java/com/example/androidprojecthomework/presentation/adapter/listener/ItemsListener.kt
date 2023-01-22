package com.example.androidprojecthomework.presentation.adapter.listener

interface ItemsListener {

    fun onClick()

    fun onElement(
        id: Int,
        personName: String,
        username: String,
        email: String,
        phone: String,
        website: String,
        street: String,
        suite: String,
        city: String,
        zipcode: String,
        lat: String,
        lng: String,
        companyName: String,
        catchPhrase: String,
        bs: String
    )
}