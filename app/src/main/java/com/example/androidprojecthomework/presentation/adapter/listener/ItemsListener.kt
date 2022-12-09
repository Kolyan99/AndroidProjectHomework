package com.example.androidprojecthomework.presentation.adapter.listener

interface ItemsListener {

    fun onClick()

    fun onElement(name: Int, date: Int, imageView: Int) {
    }
}