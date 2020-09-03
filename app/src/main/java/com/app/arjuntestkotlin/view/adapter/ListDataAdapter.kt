package com.app.arjuntestkotlin.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.arjuntestkotlin.R
import com.app.arjuntestkotlin.database.EntityAddress
import kotlinx.android.synthetic.main.address_list_raw_data.view.*


class ListDataAdapter(
    val items: ArrayList<EntityAddress>,
    val context: Context,
//        var listClickListener: listClickListener
) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.address_list_raw_data,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAddressText.text = items.get(position).coupon_code
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvAddressText = view.tvAddressText

}