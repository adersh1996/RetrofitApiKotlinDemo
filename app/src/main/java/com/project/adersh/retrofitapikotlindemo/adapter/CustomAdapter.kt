package com.project.adersh.retrofitapikotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.adersh.retrofitapikotlindemo.R
import com.project.adersh.retrofitapikotlindemo.model.Users

class CustomAdapter(
    private val context: Context,
    private val dataSet: Users
) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView
        val imageView: ImageView

        init {
            textView = itemView.findViewById(R.id.name)
            imageView = itemView.findViewById(R.id.img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.textView.text = dataSet.get(position).login
        Glide.with(context).load(dataSet.get(position).avatar_url).into(holder.imageView)

    }


}