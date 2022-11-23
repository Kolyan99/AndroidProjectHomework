package com.example.androidprojecthomework

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.ed_text1)
        val editText2 = findViewById<EditText>(R.id.ed_text2)
        val btn = findViewById<Button>(R.id.btn)
        val card_View = findViewById<CardView>(R.id.card)
        val text_View = findViewById<TextView>(R.id.text_view)
        val rb1 = findViewById<RadioButton>(R.id.rb_1)
        val rb2 = findViewById<RadioButton>(R.id.rb_2)
        val iv_image = findViewById<ImageView>(R.id.iv_image)


        rb1.setOnClickListener {
            if (rb1.isChecked) {
                rb2.isChecked = false
            } else {
                rb1.isChecked = true
            }
        }

        rb2.setOnClickListener {
            if (rb2.isChecked) {
                rb1.isChecked = false
            } else {
                rb2.isChecked = true
            }
        }

        val house = HauseBuilder.Builder
            .setFlors(3)
            .setTerrece(false)
            .setRooms(5)
            .setWindow(8)
            .build()


        btn.setOnClickListener {
            editText.text.toString()

            Log.w(
                "housebuilder",
                "${house.howManyFlors()}${house.hasTerrace()}${house.howManyWindow()}${house.howManyRooms()}"
            )

            if (editText.text.toString().isEmpty()) {
                editText.error = "email can't be empty"
            } else if (editText2.text.toString().isEmpty()) {
                editText2.error = "passworld can't be empty"

            }
        }

    }

}





