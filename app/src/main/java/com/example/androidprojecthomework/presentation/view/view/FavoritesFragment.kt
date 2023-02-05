package com.example.androidprojecthomework.presentation.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentFavoritesBinding
import com.example.androidprojecthomework.databinding.FragmentItemsBinding
import com.example.androidprojecthomework.presentation.adapter.favorites.FavoritesAdapter
import com.example.androidprojecthomework.presentation.adapter.items.ItemsAdapter
import com.example.androidprojecthomework.presentation.adapter.listener.FavoritesListener
import com.example.androidprojecthomework.presentation.model.FavoritesModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoritesFragment : Fragment(), FavoritesView, FavoritesListener  {


    @Inject
     lateinit var favoritesPresenter: FavoritesPresenter

    private var _viewBinding: FragmentFavoritesBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var favoritesAdapter: FavoritesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentFavoritesBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesPresenter.setView(this)

        favoritesAdapter = FavoritesAdapter(this)
        viewBinding.recyclerView.adapter = favoritesAdapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(context)

        favoritesPresenter.getFavorites()


    }

    override fun favReceived(list: List<FavoritesModel>) {
        favoritesAdapter.submitList(list)
    }

    override fun onDeleteFavorite(id: Int) {
        favoritesPresenter.onDeleteFavorite(id)
    }


}