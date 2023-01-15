package com.example.androidprojecthomework.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentHomeBinding
import com.example.androidprojecthomework.presentation.view.home.ItemsFragment
import com.example.androidprojecthomework.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showUserData()
        viewModel.nav.observe(viewLifecycleOwner){
            if (it != null){
                replaceGraph(it)
            }
        }

        binding.goItems.setOnClickListener {
            viewModel.goToItems()
        }

        viewModel.userCreds.observe(viewLifecycleOwner){
            binding.tvUserCreds.text = "${it.userName} \n ${it.userPassword}"
        }

        viewModel.msg.observe(viewLifecycleOwner){
            Toast.makeText(context, getString(R.string.msg_home), Toast.LENGTH_SHORT).show()
        }
    }
}