package com.example.androidprojecthomework

import android.view.Window

class HauseBuilder(val builder: Builder) {


    fun howManyFlors() = builder.flors
    fun howManyWindow() = builder.window
    fun hasTerrace() = builder.terrace
    fun howManyRooms() = builder.rooms

    companion object Builder {

        var flors: Int = 0
        var window: Int = 0
        var rooms: Int = 0
        var terrace: Boolean = false

        fun setFlors(float: Int) = apply { this.flors = flors }
        fun setRooms(rooms: Int) = apply { this.rooms = rooms }
        fun setWindow(window: Int) = apply { this.window = window }
        fun setTerrece(terrace: Boolean) = apply { this.terrace = terrace }

        fun build(): HauseBuilder {
            return HauseBuilder(this)
        }
    }

}