package com.example.androidprojecthomework.di.component

import com.example.androidprojecthomework.di.*
import com.example.androidprojecthomework.presentation.view.MainActivity
import com.example.androidprojecthomework.presentation.view.auth.HomeFragment
import com.example.androidprojecthomework.presentation.view.auth.LoginFragment
import com.example.androidprojecthomework.presentation.view.view.DescriptionFragment
import com.example.androidprojecthomework.presentation.view.view.FavoritesFragment
import com.example.androidprojecthomework.presentation.view.view.ItemsFragment
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(itemsFragment: ItemsFragment)
    fun inject(favoritesFragment: FavoritesFragment)
    fun inject(descriptionFragment: DescriptionFragment)
    fun inject(loginFragment: LoginFragment)
    fun inject(homeFragment: HomeFragment)

}