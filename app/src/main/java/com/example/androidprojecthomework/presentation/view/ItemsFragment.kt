package com.example.androidprojecthomework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Date
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_ImageView
import com.example.androidprojecthomework.utils.AppConstrants.Companion.Text_Name
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentItemsBinding
import com.example.androidprojecthomework.presentation.adapter.ItemsAdapter
import com.example.androidprojecthomework.presentation.adapter.listener.ItemsListener
import com.example.androidprojecthomework.presentation.model.ItemsModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels()

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter
        viewBinding.recyclerView.layoutManager

        //  val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        //  recyclerView.layoutManager = LinearLayoutManager(context)
        //  recyclerView.adapter = itemsAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.message.observe(viewLifecycleOwner) {
            Toast.makeText(context, getString(R.string.message), Toast.LENGTH_SHORT).show()
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val descriptionFragment = DescriptionFragment()
                val bundle = Bundle()
                bundle.putString(Text_Name, navBundle.name.toString())
                bundle.putString(Text_Date, navBundle.date.toString())
                bundle.putInt(Text_ImageView, navBundle.image)
                descriptionFragment.arguments = bundle

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, descriptionFragment)
                    .commit()
                viewModel.userNavigated()
            }
        }
    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }


    fun onElementSelected(
        name: Int,
        date: Int,
        image: Int,
    ) {
        viewModel.elementClicked(name, date, image)
    }

}
