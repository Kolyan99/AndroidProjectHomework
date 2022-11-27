package com.example.androidprojecthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isNotEmpty
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.textInputEditText)
        val editText2 = view.findViewById<EditText>(R.id.textInputEditText2)

        val login = view.findViewById<Button>(R.id.btn_main_screen)
        login.setOnClickListener {
            if (editText.text.toString().isEmpty()) {
                editText.error = getString(R.string.no_login)
            } else if (editText2.text.toString().isEmpty()) {
                editText2.error = getString(R.string.no_password)
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, Main_screenFragment())
                    .commit()
            }
        }
        val registration = view.findViewById<Button>(R.id.btn_registratoin)
        registration.setOnClickListener {
            if (editText.text.toString().isEmpty()) {
                editText.error = getString(R.string.no_login)
            } else if (editText2.text.toString().isEmpty()) {
                editText2.error = getString(R.string.no_password)
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, RegistrationFragment())
                    .commit()
            }
        }
    }
}

