package com.example.androidprojecthomework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Date
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_ImageView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Name
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentDescriptionBinding
import com.example.androidprojecthomework.databinding.FragmentLoginBinding

class DescriptionFragment : Fragment() {

    private var _viewBinding: FragmentDescriptionBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDescriptionBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        bundle?.let { safebundel ->

            val name = safebundel.getString(Text_Name)
            val date = safebundel.getString(Text_Date)
            val image = safebundel.getInt(Text_ImageView)

            viewBinding.descriptionName.text = name
            viewBinding.descriptionDate.text = date
            viewBinding.descriptionImage.setBackgroundResource(image)
            viewBinding.textclock.format24Hour

        }
    }
}