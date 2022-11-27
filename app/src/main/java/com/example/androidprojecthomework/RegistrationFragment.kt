package com.example.androidprojecthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class RegistrationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editext3 = view.findViewById<TextView>(R.id.textInputEditText3)
        val editext4 = view.findViewById<TextView>(R.id.textInputEditText4)

        val registr = view.findViewById<Button>(R.id.btn_regist)
        registr.setOnClickListener {
            if (editext3.text.toString().isEmpty()) {
                editext3.error = getString(R.string.no_name)
            } else if (editext4.text.toString().isEmpty()) {
                editext4.error = getString(R.string.no_password1)
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, Main_screenFragment())
                    .commit()
            }
        }
    }
}

