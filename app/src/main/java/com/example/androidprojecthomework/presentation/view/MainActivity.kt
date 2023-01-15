package com.example.androidprojecthomework.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.Control
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.ActivityMainBinding
import com.example.androidprojecthomework.presentation.view.auth.HomeFragment
import com.example.androidprojecthomework.presentation.view.auth.LoginFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)

        viewModel.checkUserExists()

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController

        viewModel.userExists.observe(this){
            navController.setGraph(it)
        }
    }
}