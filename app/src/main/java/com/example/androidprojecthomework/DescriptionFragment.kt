package com.example.androidprojecthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView

class DescriptionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decriptionImage = view.findViewById<ImageView>(R.id.descriptionImage)
        val descriptionName = view.findViewById<TextView>(R.id.descriptionName)
        val descriptionDate = view.findViewById<TextView>(R.id.descriptionDate)
        val clock = view.findViewById<TextClock>(R.id.textclock)

        val bundle = arguments
        bundle?.let { safebundel ->

            val name = safebundel.getString("name")
            val date = safebundel.getString("date")
            val image = safebundel.getInt("imageView")

            descriptionName.text = name
            descriptionDate.text = date
            decriptionImage.setBackgroundResource(image)
            clock.format24Hour



        }


    }


}