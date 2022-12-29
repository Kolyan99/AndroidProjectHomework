package com.example.androidprojecthomework.presentation.view

import com.example.androidprojecthomework.domain.AuthInteractor
import javax.inject.Inject

class DescriptionPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var descriptionView: DescriptionView

    fun setView(descriptionFragment: DescriptionFragment) {
        descriptionView = descriptionFragment
    }

    fun getArguments(name: String?, date: String?, imageView: Int) {
        descriptionView.displayItemData(
            when (name.isNullOrEmpty()) {
                true -> " No Name "
                false -> name
            },
            when (date.isNullOrEmpty()) {
                true -> "No Date"
                false -> date
            },
            imageView
        )
    }

    fun logoutUser() {
        authInteractor.logoutUser()
        descriptionView.userLoggedOut()
    }
}