package com.example.androidprojecthomework.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

object NavHelper {

    fun Fragment.navigate(destination: Int){
        findNavController().navigate(destination)
    }

    fun Fragment.replaceGraph(graph: Int){
        findNavController().setGraph(graph)
    }

    fun Fragment.navigateWithDeleteBack(destination: Int, fragmentRemove: Int){
        val navOption = NavOptions.Builder()
        navOption.setPopUpTo(fragmentRemove, true)
        findNavController().navigate(
            destination,
            null,
            navOption.build()
        )
    }

    fun Fragment.navigateWithBundel(destination: Int, bundle: Bundle){
        findNavController().navigate(destination,bundle)
    }
}