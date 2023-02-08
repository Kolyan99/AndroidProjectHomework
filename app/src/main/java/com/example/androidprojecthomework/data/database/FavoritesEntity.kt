package com.example.androidprojecthomework.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoritesEntity")
data class FavoritesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val personName: String,
    @ColumnInfo(name ="username")
    val username: String,
    @ColumnInfo(name ="email")
    val email: String,
    @ColumnInfo(name ="phone")
    val phone: String,
    @ColumnInfo(name ="website")
    val website: String,
    @ColumnInfo(name ="street")
    val street: String,
    @ColumnInfo(name ="suite")
    val suite: String,
    @ColumnInfo(name ="city")
    val city: String,
    @ColumnInfo(name ="zipcode")
    val zipcode: String,
    @ColumnInfo(name ="compName")
    val companyName: String,
    @ColumnInfo(name ="catchPhrase")
    val catchPhrase: String,
    @ColumnInfo(name ="bs")
    val bs: String,
    @ColumnInfo(name ="lat")
    val lat: String,
    @ColumnInfo(name ="lng")
    val lng: String,
)

