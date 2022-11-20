package com.example.androidprojecthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val layoutName = findViewById<TextInputLayout>(R.id.ex_text)
        // val layoutPassword = findViewById<TextInputLayout>(R.id.ex_text2)

        val editText = findViewById<EditText>(R.id.ex_text)
        val editText2 = findViewById<EditText>(R.id.ex_text2)

        val button = findViewById<Button>(R.id.btn_display)
        val textView = findViewById<TextView>(R.id.tv_text)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Information")
            .setMessage(getString(R.string.info))
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, _ ->
                Toast.makeText(this, getString(R.string.text), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancle") { dialog, _ ->
                dialog.cancel()
            }

        button.setOnClickListener {
            dialog.show()

            if (editText.text.toString().isEmpty()) {
                editText.error = "No name "
            } else if (editText2.text.toString().isEmpty()) {
                editText2.error = "No password "
            }
        }
    }
}





