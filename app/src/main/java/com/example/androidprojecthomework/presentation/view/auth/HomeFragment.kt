package com.example.androidprojecthomework.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentHomeBinding
import com.example.androidprojecthomework.presentation.model.StringModel
import com.example.androidprojecthomework.presentation.view.view.FavoritesFragment
import com.example.androidprojecthomework.presentation.view.view.ItemsFragment
import com.example.androidprojecthomework.utils.NavHelp.replaceGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private var _viwBinding: FragmentHomeBinding? = null
    private val viwBinding get() = _viwBinding!!

   @Inject
   lateinit var homePresenter: HomePresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viwBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viwBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)

        homePresenter.getString()


        viwBinding.btnHome.setOnClickListener {
           homePresenter.goItems()
        }

    }

    override fun goItems(destanation: Int) {
        replaceGraph(destanation)
    }

    override fun showString(string: List<StringModel>) {
        viwBinding.textView.text = "$string"
    }
}

