package com.example.fragmentkt.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentkt.R
import com.example.fragmentkt.databinding.FragmentGoldBinding
import com.example.noteukt.Adapter.RecyclerAdapter

class GoldFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentGoldBinding.inflate(LayoutInflater.from(activity),container,false)

        val list = mutableListOf<String>("1","2","3","4","5","1","2","3","4","5")
        binding.recGOld.layoutManager = LinearLayoutManager(activity)
        binding.recGOld.adapter = RecyclerAdapter(list)

        return binding.root
    }

}