package com.example.androidprojecthomework.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.androidprojecthomework.App
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.ActivityMainBinding
import com.example.androidprojecthomework.di.PresentationModule
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        (applicationContext as App).provideAppComponent().inject(this)

        mainPresenter.setView(this)
        mainPresenter.checkUserExists()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, nav, _ ->
            if (nav.id == R.id.loginFragment || nav.id == R.id.homeFragment) {
                binding.bottomNavigation.visibility = GONE
            } else {
                binding.bottomNavigation.visibility = VISIBLE
            }
        }
    }

    override fun userExistsResult(userExists: Boolean) {
        when (userExists) {
            true -> navController.setGraph(R.navigation.main_graph)
            false -> navController.setGraph(R.navigation.auth_graph)
        }
    }
}