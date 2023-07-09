package com.example.noteukt.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentkt.DataClass.DataModel
import com.example.fragmentkt.databinding.DataLayoutBinding
import retrofit2.Response

class RecyclerAdapter(val list: MutableList<DataModel>) :
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
        holder.item.tvData.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }


}