package com.example.androidprojecthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

    }
    override fun onBackPressed() {
       super.onBackPressed()
       finishAffinity()
    }

}

