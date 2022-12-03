package com.example.androidprojecthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.adapter.ItemsAdapter
import com.example.androidprojecthomework.listener.ItemsListener
import com.example.androidprojecthomework.model.ItemsModel


class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewModel.getList()
        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }
        viewModel.message.observe(viewLifecycleOwner) { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
        viewModel.element.observe(viewLifecycleOwner) { element ->
            val detailsFragment = DescriptionFragment()
            val bundel = Bundle()
            bundel.putString(getString(R.string.name), element.name)
            bundel.putString(getString(R.string.date), element.date)
            bundel.putInt(getString(R.string.imageView), element.imageView)
            detailsFragment.arguments = bundel
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, detailsFragment)
                .addToBackStack(getString(R.string.Description))
                .commit()
        }
    }

    override fun onClick() {
        viewModel.getMessage()
    }

    override fun onElement(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }
}