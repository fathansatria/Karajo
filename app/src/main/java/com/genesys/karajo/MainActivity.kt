package com.genesys.karajo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var apiInterface : ApiInterface? = null
    var username : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = intent.getStringExtra("Username")

        add_pekerjaan.setOnClickListener {

            var intent = Intent(this@MainActivity, TambahPekerjaan::class.java)
            intent.putExtra("Username", username)
            startActivity(intent)
        }


        rv_pekerjaan.layoutManager = LinearLayoutManager(this)
        apiInterface = ApiService.getClient().create(ApiInterface::class.java)

        val kerjaanCall  = apiInterface?.getAllPekerjaan("list_pekerjaan", username!!)
        kerjaanCall?.enqueue(object : Callback<List<Pekerjaan>>{
            override fun onResponse(
                call: Call<List<Pekerjaan>>?,
                response: Response<List<Pekerjaan>>?
            ) {

                var listPekerjaan = response?.body() as ArrayList<Pekerjaan>
                var adapter = PekerjaanAdapter(this@MainActivity, listPekerjaan)
                rv_pekerjaan.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<Pekerjaan>>?, t: Throwable?) {

                Toast.makeText(this@MainActivity, "Koneksi Terputus", Toast.LENGTH_LONG).show()
            }

        })



    }

    override fun onBackPressed() {
        //cant back
    }
}
