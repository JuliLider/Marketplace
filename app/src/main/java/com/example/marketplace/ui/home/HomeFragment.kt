package com.example.marketplace.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.ProductAdapter
import com.example.marketplace.R
import com.example.marketplace.databinding.FragmentHomeBinding
import java.util.ArrayList


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    //private lateinit var _binding: FragmentHomeBinding? = null//

    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!//

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmento: View = inflater.inflate(R.layout.fragment_home,container,false)
        /*homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.
        textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return fragmento
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var productTitle: ArrayList<String> = ArrayList()

        productTitle.add(resources.getString(R.string.text_tarea_1))
        productTitle.add(resources.getString(R.string.text_tarea_2))
        productTitle.add(resources.getString(R.string.text_tarea_3))

        var productTimes: ArrayList<String> = ArrayList()
        productTimes.add("$10.000")
        productTimes.add("$50.000")
        productTimes.add("$35.000")

        var productPlaces: ArrayList<String> = ArrayList()
        productPlaces.add("Hombre")
        productPlaces.add("Mujer")
        productPlaces.add("Niños")

        var info:  Bundle = Bundle()
        info.putStringArrayList("productos", productTitle)
        info.putStringArrayList("precios", productTimes)
        info.putStringArrayList("categorias", productPlaces)

        listRecyclerView = requireView().findViewById(R.id.recyclerTodoList)
        myAdapter = ProductAdapter(activity as AppCompatActivity,info)

        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }
}

