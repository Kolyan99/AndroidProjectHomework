package com.example.androidprojecthomework.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.databinding.ItemPictureBinding
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ItemPictureBinding,
    private val itemsListener: ItemsListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsModel: ItemsModel) {
        viewBinding.tvId.text = "${itemsModel.id}"
        viewBinding.tvName.text = itemsModel.username
        viewBinding.tvEmail.text = itemsModel.email
        viewBinding.tvWebsite.text = itemsModel.website
        viewBinding.tvPhone.text = itemsModel.phone
        viewBinding.tvAddress.text = itemsModel.address.toString()
        viewBinding.tvGeo.text = itemsModel.geo.toString()
        viewBinding.tvCompany.text = itemsModel.company.toString()
        viewBinding.tvStreet.text = itemsModel.street
        viewBinding.tvSuite.text = itemsModel.suite
        viewBinding.tvCity.text = itemsModel.city
        viewBinding.tvZipcode.text = itemsModel.zipcode
        viewBinding.tvLat.text = itemsModel.lat
        viewBinding.tvLng.text = itemsModel.lng
        viewBinding.tvCatchPhrase.text = itemsModel.catchPhrase
        viewBinding.tvBs.text = itemsModel.bs

//          imageView.setOnClickListener {
//            itemsListener.onClick()
//        }
        itemView.setOnClickListener {
            itemsListener.onElement(
                itemsModel.id,
                itemsModel.username,
                itemsModel.email,
                itemsModel.website,
                itemsModel.phone,
                itemsModel.address,
                itemsModel.geo,
                itemsModel.company,
                itemsModel.street,
                itemsModel.suite,
                itemsModel.city,
                itemsModel.zipcode,
                itemsModel.lat,
                itemsModel.lng,
                itemsModel.catchPhrase,
                itemsModel.bs
            )
        }
    }
}