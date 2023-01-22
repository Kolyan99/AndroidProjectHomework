package com.example.androidprojecthomework.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.ItemPictureBinding
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.ItemsModel

class ItemsAdapter(
    private val itemsListener: ItemsListener
): RecyclerView.Adapter<ItemsViewHolder>() {


    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>){
        this.listItems.clear()
        this.listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemPictureBinding.inflate(LayoutInflater.from(parent.context),parent,false)
     //   val view = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent,false)
        return ItemsViewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
      holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}