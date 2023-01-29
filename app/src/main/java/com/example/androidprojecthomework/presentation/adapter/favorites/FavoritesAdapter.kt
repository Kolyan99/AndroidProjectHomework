package com.example.androidprojecthomework.presentation.adapter.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.databinding.ItemFavoritesBinding
import com.example.androidprojecthomework.databinding.ItemPictureBinding
import com.example.androidprojecthomework.presentation.adapter.items.ItemsViewHolder
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel

class FavoritesAdapter(

): RecyclerView.Adapter<FavoritesViewHolder>() {


    private var listItems = mutableListOf<FavoritesModel>()

    fun submitList(list: List<FavoritesModel>){
        this.listItems.clear()
        this.listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val viewBinding = ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoritesViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}
