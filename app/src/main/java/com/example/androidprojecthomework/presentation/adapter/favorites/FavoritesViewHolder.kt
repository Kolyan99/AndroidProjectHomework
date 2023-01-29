package com.example.androidprojecthomework.presentation.adapter.favorites

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.databinding.ItemFavoritesBinding
import com.example.androidprojecthomework.databinding.ItemPictureBinding
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import com.squareup.picasso.Picasso

class FavoritesViewHolder(
    private val viewBinding: ItemFavoritesBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(favItems: FavoritesModel) {
        viewBinding.tvName.text = favItems.personName
        Picasso.get().load(Uri.parse(favItems.city)).into(viewBinding.imageView)

    }
}
