package com.example.androidprojecthomework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Date
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_ImageView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Name
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.data.ItemsRepositoryImp
import com.example.androidprojecthomework.databinding.FragmentItemsBinding
import com.example.androidprojecthomework.databinding.FragmentLoginBinding
import com.example.androidprojecthomework.domain.ItemsInteractor
import com.example.androidprojecthomework.presentation.adapter.ItemsAdapter
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.model.ItemsModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImp()))

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getData()

        }

    override fun onClick() {
        itemsPresenter.imageViewClick()
    }

    override fun onElement(name: Int, date: Int, imageView: Int) {
        itemsPresenter.elementSelected(name, date, imageView)

    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageClick(msg:Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun goToDescription(name: Int, date: Int, imageView: Int) {
        val detailsFragment = DescriptionFragment()
        val bundel = Bundle()
        bundel.putString(Text_Name, name.toString())
        bundel.putString(Text_Date, date.toString())
        bundel.putInt(Text_ImageView, imageView)
        detailsFragment.arguments = bundel
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack(getString(R.string.Description))
            .commit()
    }
}