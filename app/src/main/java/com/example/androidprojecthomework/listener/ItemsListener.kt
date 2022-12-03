package com.example.androidprojecthomework.listener

interface ItemsListener {

    fun onClick()

    fun onElement(name: String, date: String, imageView: Int) {
    }
}