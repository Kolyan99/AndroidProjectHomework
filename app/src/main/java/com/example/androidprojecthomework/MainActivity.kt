package com.example.androidprojecthomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoActivity2 = findViewById<Button>(R.id.btnGoActivity2)
        btnGoActivity2.setOnClickListener{
            startActivity(
                Intent(this, MainActivity2::class.java)
            )
        }


    }
}