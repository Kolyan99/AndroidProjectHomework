package com.example.androidprojecthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.androidprojecthomework.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.setting -> startMainActivity2(this, getString(R.string.hello_world))
            R.id.setting -> startMainActivity2(this, getString(R.string.hello_children))


        return super.onOptionsItemSelected(item)

    }


}
}


