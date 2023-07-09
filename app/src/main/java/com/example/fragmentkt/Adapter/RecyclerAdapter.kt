package com.example.noteukt.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentkt.databinding.DataLayoutBinding

class RecyclerAdapter(val list:MutableList<String>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(val item: DataLayoutBinding) : RecyclerView.ViewHolder(item.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item.tvData.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }


}