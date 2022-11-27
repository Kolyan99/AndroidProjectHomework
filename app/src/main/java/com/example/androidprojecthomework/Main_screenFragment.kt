package com.example.androidprojecthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import android.widget.Toast.makeText as makeText1


class Main_screenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alerDialog()

    }
    private fun alerDialog()
    {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Information")
        builder.setMessage("You have successfully registered")
        builder.setPositiveButton("OK"){dialog, i ->
        }
        builder.setNegativeButton("Cancle"){dialof, i ->

        }
        builder.show()
    }
}