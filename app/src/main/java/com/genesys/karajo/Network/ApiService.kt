package com.genesys.karajo.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class ApiService {

    companion object{

        const val URL = "http://192.168.43.249"
        const val URL2 = "https://sistemkarajo.000webhostapp.com/api/"

        var retrofit : Retrofit? = null

        fun getClient(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }


    }
}