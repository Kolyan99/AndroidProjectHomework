package com.example.androidprojecthomework.presentation.adapter.favorites

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.databinding.ItemFavoritesBinding
import com.example.androidprojecthomework.databinding.ItemPictureBinding
import com.example.androidprojecthomework.presentation.adapter.listener.FavoritesListener
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import com.squareup.picasso.Picasso

class FavoritesViewHolder(
    private val viewBinding: ItemFavoritesBinding,
    private val favoritesListener: FavoritesListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(favItems: FavoritesModel) {
        viewBinding.tvId.text = favItems.id.toString()
        viewBinding.tvName.text = favItems.personName
        viewBinding.tvUsername.text = favItems.username
        viewBinding.tvEmail.text = favItems.email
        viewBinding.tvPhone.text = favItems.phone
        viewBinding.tvWebsite.text = favItems.website
        viewBinding.tvStreet.text = favItems.street
        viewBinding.tvSuite.text = favItems.suite
        viewBinding.tvCity.text = favItems.city
        viewBinding.tvZipcode.text = favItems.zipcode
        viewBinding.tvLat.text = favItems.lat
        viewBinding.tvLng.text = favItems.lng
        viewBinding.tvCompany.text = favItems.companyName
        viewBinding.tvCatchPhrase.text = favItems.catchPhrase
        viewBinding.tvBs.text = favItems.bs


        viewBinding.deleteFavorite.setOnClickListener {
            favoritesListener.onDeleteFavorite(favItems.id)
        }

    }
}
