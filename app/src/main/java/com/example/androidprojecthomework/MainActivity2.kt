package com.example.androidprojecthomework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView1  = findViewById<TextView>(R.id.textView1)
        val text = intent.getStringExtra(KEY1)

        val textView2 = findViewById<TextView>(R.id.textView2)
        val text2 = intent.getStringExtra(KEY2)

        val text3:String = intent.getStringExtra(KEY3)?: getString(R.string.hello_children)
        supportActionBar?.title = text3
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }





    companion object {

        private const val  KEY1 = "1"
        private const val  KEY2 = "2"
        private const val  KEY3 = "3"


        fun startMainActivity2(contex: Context, string1: String,first:String) {
            val intent = Intent(contex, MainActivity2::class.java)
            intent.putExtra(KEY1, string1)
            intent.putExtra(KEY2, first)
            contex.startActivity(intent)
        }


            fun statrtMainActivitygo(contex: Context,string: String){
                val intent = Intent(contex,MainActivity2::class.java)
                intent.putExtra(KEY3,string)
                contex.startActivity(intent)
            }

        }

    }


