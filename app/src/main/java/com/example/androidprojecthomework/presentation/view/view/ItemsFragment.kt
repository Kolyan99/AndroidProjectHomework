package com.example.androidprojecthomework.presentation.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Date
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_ImageView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Name
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentItemsBinding
import com.example.androidprojecthomework.presentation.adapter.ItemsAdapter
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.ItemsModel
import com.example.androidprojecthomework.utils.NavHelp.navigate
import com.example.androidprojecthomework.utils.NavHelp.navigateWithBundel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.setView(this)


        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter
        viewBinding.recyclerView.layoutManager =LinearLayoutManager(context)

        itemsPresenter.getItems()

    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElement(name: Int, date: Int, imageView: Int) {
        itemsPresenter.itemClicked(name, date, imageView)

    }

    override fun itemsReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClick(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun itemsClicked(navigationData: NavigateWithBundel, destination: Int) {
       // val detailsFragment = DescriptionFragment()
        val bundel = Bundle()
        bundel.putString(Text_Name, navigationData.toString())
        bundel.putString(Text_Date, navigationData.toString())
        bundel.putInt(Text_ImageView, navigationData.imageView)
        //detailsFragment.arguments = bundel

        navigateWithBundel(destination, bundel)
    }
}