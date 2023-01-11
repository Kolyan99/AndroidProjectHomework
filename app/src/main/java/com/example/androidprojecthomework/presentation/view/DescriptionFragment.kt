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
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DescriptionFragment : Fragment(), DescriptionView {

    private var _viewBinding: FragmentDescriptionBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var descriptionPresenter: DescriptionPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDescriptionBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        descriptionPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safebundel ->
            descriptionPresenter.getArguments(
                safebundel.getString(Text_Name),
                safebundel.getString(Text_Date),
                safebundel.getInt(Text_ImageView)
            )
            viewBinding.textclock.format24Hour

        }

        viewBinding.btnLogout.setOnClickListener {
            descriptionPresenter.logoutUser()
        }
    }

    override fun userLoggedOut() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
    }

    override fun displayItemData(name: String, date: String, imageView: Int) {
        viewBinding.descriptionName.text = name
        viewBinding.descriptionDate.text = date
        viewBinding.descriptionImage.setBackgroundResource(imageView)
    }
}