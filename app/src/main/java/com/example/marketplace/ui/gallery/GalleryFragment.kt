package com.example.marketplace.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.marketplace.R
import com.example.marketplace.databinding.FragmentGalleryBinding


class GalleryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Inflate the layout for this fragment
        val fragmento = inflater.inflate(R.layout.fragment_gallery, container, false)

        var producto = requireArguments().getString("producto")
        var precio = requireArguments().getString("precio")
        var categoria = requireArguments().getString("categoria")

        var textViewProducto: TextView = fragmento.findViewById(R.id.textViewProduct)
        var textViewPrecio: TextView = fragmento.findViewById(R.id.textViewPrice)
        var textViewCategoria: TextView = fragmento.findViewById(R.id.textViewCategory)

        textViewProducto.text = producto
        textViewPrecio.text = precio
        textViewCategoria.text = categoria

        return fragmento
    }
}