package com.example.androidprojecthomework.presentation.view.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprojecthomework.App
import com.example.androidprojecthomework.databinding.FragmentDescriptionBinding
import com.example.androidprojecthomework.di.PresentationModule
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Date
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_ImageView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Name
import com.example.androidprojecthomework.utils.NavHelp.replaceGraph
import javax.inject.Inject


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

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

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

    override fun userLoggedOut(graph: Int) {
        replaceGraph(graph)
    }

    override fun displayItemData(name: String, date: String, imageView: Int) {
        viewBinding.descriptionName.text = name
        viewBinding.descriptionDate.text = date
        viewBinding.descriptionImage.setBackgroundResource(imageView)
    }
}