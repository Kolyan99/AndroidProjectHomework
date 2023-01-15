package com.example.androidprojecthomework.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Date
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_ImageView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Name
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentDescriptionBinding
import com.example.androidprojecthomework.presentation.view.auth.LoginFragment
import com.example.androidprojecthomework.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DescriptionFragment : Fragment() {

    private var _viewBinding: FragmentDescriptionBinding? = null
    private val viewBinding get() = _viewBinding!!


    private val viewModel: DescriptionViewModel by viewModels()


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
        viewModel.nav.observe(viewLifecycleOwner){
            if(it != null){
                replaceGraph(it)
            }
        }

        viewBinding.btnLogout.setOnClickListener {
            viewModel.logoutUser()
        }


        viewModel.msg.observe(viewLifecycleOwner){
            Toast.makeText(context, getString(R.string.msg_descript), Toast.LENGTH_SHORT).show()
        }
    }
}