package com.example.marketplace

import android.icu.text.CaseMap
import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.ui.gallery.GalleryFragment

class ProductAdapter (context: AppCompatActivity,
val info: Bundle): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    private var context: AppCompatActivity=context

    var productTitle: ArrayList<String> = info.getStringArrayList("producto") as ArrayList<String>
    var productTimes: ArrayList<String> = info.getStringArrayList("precio") as ArrayList<String>
    var productPlaces: ArrayList<String> = info.getStringArrayList("categoria") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent,  false)

        return ProductViewHolder(layout)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var textViewTask = holder.layout.findViewById<TextView>(R.id.textViewTask)
        textViewTask.text = productTitle [position]

        var textViewTime = holder.layout.findViewById<TextView>(R.id.textViewTime)
        textViewTime.text = productTimes [position]

        holder.layout.setOnClickListener{
            Toast.makeText(holder.itemView.context, textViewTask.text, Toast.LENGTH_LONG).show()
            val datos = Bundle ()
            datos.putString("producto", textViewTask.text as String)
            datos.putString("precio", textViewTime.text as String)
            datos.putString("categoria", productPlaces [position])

            context.getSupportFragmentManager ()?.beginTransaction()
                ?.setReorderingAllowed (true)
                ?.replace(R.id.fragment_container_view_tag, GalleryFragment ::class.java, datos,  "gallery")
                ?.addToBackStack("")
                ?.commit()
        }


    }

    override fun getItemCount(): Int {
        return productTitle.size

    }
}