package com.example.androidprojecthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecthomework.adapter.ItemsAdapter
import com.example.androidprojecthomework.listener.ItemsListener
import com.example.androidprojecthomework.model.ItemsModel


class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter


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

        val listItems = listOf<ItemsModel>(
           ItemsModel(R.drawable.ford,
               "Ford mustang",
               "26.10.2023",
               "Sport car"
           ),
            ItemsModel(R.drawable.lamborgini,
                "Lamborghini Gallardo",
                "10.9.2020",
                "Sport car"
            ),
            ItemsModel(R.drawable.actonmartin,
                "Acton Martin",
                "10.04.2022",
                "Sport car"
            ),
            ItemsModel(R.drawable.selbycobra,
                "Selby Cobra",
                "12.05.2019",
                "Sport car"
            ),
            ItemsModel(R.drawable.maseratigranturismo,
                "Maserati Gran Turismo",
                "17.04.2020",
                "Sport car"
            ),
            ItemsModel(R.drawable.ferrari,
                "Ferrari",
                "07.09.2021",
                "Sport car"
            ),
            ItemsModel(R.drawable.jaguar,
                "Jaguar",
                "14.06.2022",
                "Sport car"
            ),
            ItemsModel(R.drawable.ferraricalifornia,
                "Ferrari California",
                "30.08.2018",
                "Sport car"
            ),
            ItemsModel(R.drawable.audir8,
                "Audi r8",
                "03.02.2018",
                "Sport car"
            ),
        )

        itemsAdapter.submitList(listItems)

    }

    override fun onClick() {
        Toast.makeText(context, "ImageView cliked", Toast.LENGTH_SHORT).show()
    }

    override fun onElement(name: String, date: String, imageView: Int) {

        val detailsFragment = DescriptionFragment()
        val bundel = Bundle()
        bundel.putString("name", name)
        bundel.putString("date", date)
        bundel.putInt("imageView", imageView)
        detailsFragment.arguments = bundel
       parentFragmentManager.beginTransaction()
           .add(R.id.activity_container, detailsFragment)
           .addToBackStack("Description")
           .commit()
    }
}