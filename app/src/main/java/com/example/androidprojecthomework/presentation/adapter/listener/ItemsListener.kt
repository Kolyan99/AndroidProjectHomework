package com.example.androidprojecthomework.presentation.adapter.listener

import com.example.androidprojecthomework.data.model.Address
import com.example.androidprojecthomework.data.model.Company
import com.example.androidprojecthomework.data.model.Geo

interface ItemsListener {

    fun onClick()

    fun onElement(
        name: Int,
        date: String,
        imageView: String,
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
        bs: String
    ) {
    }
}