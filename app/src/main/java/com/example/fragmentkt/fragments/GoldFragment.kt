package com.example.fragmentkt.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentkt.DataClass.DataModel
import com.example.fragmentkt.contract.ApiContract
import com.example.fragmentkt.databinding.FragmentGoldBinding
import com.example.noteukt.Adapter.RecyclerAdapter
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class GoldFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentGoldBinding.inflate(LayoutInflater.from(activity),container,false)

       val retrofit = Retrofit.Builder()
           .addConverterFactory(ScalarsConverterFactory.create())
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        val apiService = retrofit.create(ApiContract::class.java)

       val call = apiService.getData()
        call.enqueue(object :Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                val jsonArray = JSONArray(response.body())
                val dataList = mutableListOf<DataModel>()
                for (i in 0 until jsonArray.length()){
                    val title:String = jsonArray.getJSONObject(i).get("title").toString()
                    dataList.add(DataModel(0,0,title,""))

                }

                binding.recGOld.apply {
                    adapter = RecyclerAdapter(dataList)
                    layoutManager = LinearLayoutManager(activity)

                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
            }

        })



        return binding.root
    }

}