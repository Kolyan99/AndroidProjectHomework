package com.example.androidprojecthomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnGoActivity4 = findViewById<Button>(R.id.btnGoActivity4)

        btnGoActivity4.setOnClickListener {
            startActivity(
                Intent(this, MainActivity4::class.java))
        }

    }
}