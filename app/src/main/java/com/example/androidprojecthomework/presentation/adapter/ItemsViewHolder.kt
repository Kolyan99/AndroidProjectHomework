package com.example.androidprojecthomework.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: ItemsListener
) : RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel) {

        val name = view.findViewById<TextView>(R.id.tv_name)
        val date = view.findViewById<TextView>(R.id.tv_date)
        val text = view.findViewById<TextView>(R.id.tv_text)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val image = view.findViewById<ImageView>(R.id.iv_image2)

        name.setText(itemsModel.name)
        imageView.setBackgroundResource(itemsModel.image)
        date.setText(itemsModel.date)
        text.setText(itemsModel.text)

        imageView.setOnClickListener {
            itemsListener.onClick()
        }
        itemView.setOnClickListener {
            itemsListener.onElement(
                itemsModel.name,
                itemsModel.date,
                itemsModel.image
            )
        }
    }
}