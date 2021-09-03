package com.example.kotlinshop.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinshop.R
import com.example.kotlinshop.databinding.ItemListBinding
import com.example.kotlinshop.model.Data
import com.example.kotlinshop.view.NewActivity

class ScooterAdapter(
    var context: Context, var scooterlList: ArrayList<Data>
) : RecyclerView.Adapter<ScooterAdapter.ScooterViewHolder>() {

    inner class ScooterViewHolder(var v: ItemListBinding) : RecyclerView.ViewHolder(v.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScooterViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val v =
            DataBindingUtil.inflate<ItemListBinding>(inflater, R.layout.item_list, parent, false)
        return ScooterViewHolder(v)

    }

    override fun onBindViewHolder(holder: ScooterViewHolder, position: Int) {

        val newList = scooterlList[position]

        holder.v.isData = scooterlList[position]
        holder.v.root.setOnClickListener {

            val img  = newList.img
            val title  = newList.title                 // добавить цену
            val description  = newList.description
            val price = newList.price


            val mIntent = Intent(context, NewActivity :: class.java)

            mIntent.putExtra("img", img)
            mIntent.putExtra("title", title)            // добавить цену
            mIntent.putExtra("description", description)
            mIntent.putExtra("price", price)

            context.startActivity(mIntent)
        }

    }

    override fun getItemCount(): Int {

        return scooterlList.size

    }

}