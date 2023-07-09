package com.example.fragmentkt.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentkt.DataClass.DataModel
import com.example.fragmentkt.R
import com.example.fragmentkt.contract.ApiContract
import com.example.fragmentkt.databinding.FragmentGoldBinding
import com.example.noteukt.Adapter.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GoldFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentGoldBinding.inflate(LayoutInflater.from(activity),container,false)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        val apiService = retrofit.create(ApiContract::class.java)
        val call = apiService.getData()
        call.enqueue(object :Callback<MutableList<DataModel>>{
            override fun onResponse(
                call: Call<MutableList<DataModel>>,
                response: Response<MutableList<DataModel>>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<MutableList<DataModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        val list = mutableListOf<String>("1","2","3","4","5","1","2","3","4","5")
        binding.recGOld.layoutManager = LinearLayoutManager(activity)
        binding.recGOld.adapter = RecyclerAdapter(list)

        return binding.root
    }

}