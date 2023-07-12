package com.example.fragmentkt.contract

import com.example.fragmentkt.DataClass.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiContract {
@GET("posts")
fun getData():Call<String>


}