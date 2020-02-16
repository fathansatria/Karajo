package com.genesys.karajo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService
import kotlinx.android.synthetic.main.activity_daftar_pekerja.*
import kotlinx.android.synthetic.main.activity_daftar_pekerja.toolbar_polos
import kotlinx.android.synthetic.main.activity_daftar_pekerja.tv_alamat
import kotlinx.android.synthetic.main.activity_detail_pekerja.*
import kotlinx.android.synthetic.main.toolbar_polos.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class DaftarPekerja : AppCompatActivity() {

    var pekerjaan = Pekerjaan()
    var apiInterface : ApiInterface? = null
    var list_pelamar :ArrayList<Pekerja>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pekerja)

        val id_pekerjaan = intent.getStringExtra("id_pekerjaan")
        Log.i("id", id_pekerjaan)
        apiInterface = ApiService.getClient().create(ApiInterface::class.java)

        rv_pelamar.layoutManager = LinearLayoutManager(this)

        getDataPekerjaan(id_pekerjaan!!)
        getListPelamar(id_pekerjaan)



    }

    fun getDataPekerjaan(id : String){

        var kerjaanCall = apiInterface?.getPekerjaan("get_pekerjaan", id)
        kerjaanCall?.enqueue(object : Callback<Pekerjaan>{
            override fun onResponse(call: Call<Pekerjaan>?, response: Response<Pekerjaan>?) {

                var pekerjaans = response?.body() as Pekerjaan
                pekerjaan = pekerjaans

                tv_nama_pekerjaan.text = pekerjaans.pekerjaan_nama
                toolbar_polos.tv_judul.text = pekerjaans.pekerjaan_nama


                Log.i("id", pekerjaans.pekerjaan_foto)


                tv_gaji.text = "Gaji : Rp." + pekerjaans.pekerjaan_gaji
                tv_alamat.text = "Alamat : " + pekerjaans.pekerjaan_alamat

            }

            override fun onFailure(call: Call<Pekerjaan>?, t: Throwable?) {

                Toast.makeText(this@DaftarPekerja, "Koneksi Terputus", Toast.LENGTH_LONG).show()

            }

        })

    }


    fun getListPelamar(id : String){

        var kerjaanCall = apiInterface?.getAllPekerja("get_all_pekerja", id)
        kerjaanCall?.enqueue(object : Callback<List<Pekerja>>{
            override fun onResponse(call: Call<List<Pekerja>>?, response: Response<List<Pekerja>>?) {

                list_pelamar = response?.body() as ArrayList<Pekerja>
                var adapterPekerja = PekerjaAdapter(this@DaftarPekerja, list_pelamar!!)
                rv_pelamar.adapter = adapterPekerja
                adapterPekerja.notifyDataSetChanged()


            }

            override fun onFailure(call: Call<List<Pekerja>>?, t: Throwable?) {

                Toast.makeText(this@DaftarPekerja, "Belum ada Pelamar", Toast.LENGTH_LONG).show()

            }

        })

    }





}
