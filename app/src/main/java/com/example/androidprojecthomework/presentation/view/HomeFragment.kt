package com.example.androidprojecthomework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentHomeBinding
import com.example.androidprojecthomework.presentation.model.UserModel
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _viwBinding: FragmentHomeBinding? = null
    private val viwBinding get() = _viwBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viwBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viwBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}

