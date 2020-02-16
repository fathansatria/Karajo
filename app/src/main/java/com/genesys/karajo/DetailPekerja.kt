package com.genesys.karajo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService
import kotlinx.android.synthetic.main.activity_detail_pekerja.*
import kotlinx.android.synthetic.main.toolbar_polos.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent



class DetailPekerja : AppCompatActivity() {

    var username : String? = null
    var apiInterface : ApiInterface? = null
    var pekerja : Pekerja? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pekerja)

        apiInterface = ApiService.getClient().create(ApiInterface::class.java)

        username = intent.getStringExtra("pekerja_username")

        getDataPekerja(username!!)

        btn_hubungi.setOnClickListener {

            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.type = "vnd.android-dir/mms-sms"
            smsIntent.putExtra("address", pekerja?.pekerja_telp)
            smsIntent.putExtra("sms_body", "Selamat Siang, " + pekerja?.pekerja_nama + " menerima lamaran anda pada pekerjaan yang tertera pada aplikasi Karajo")
            startActivity(smsIntent)

        }

        iv_foto.setOnClickListener {

            var intent = Intent(this@DetailPekerja, Webview::class.java)
            intent.putExtra("url", pekerja?.pekerja_foto)
            startActivity(intent)



        }


    }

    fun getDataPekerja(username : String){

        var pekerjaCall = apiInterface?.getPekerja("get_pekerja", username)
        pekerjaCall?.enqueue(object : Callback<Pekerja> {
            override fun onResponse(call: Call<Pekerja>?, response: Response<Pekerja>?) {

                var pekerjas = response?.body() as Pekerja
                pekerja = pekerjas


                toolbar_polos.tv_judul.text = "Detail : " + pekerjas.pekerja_nama

                tv_nama.text = pekerjas.pekerja_nama
                tv_nik.text = " NIK  : " + pekerjas.pekerja_NIK
                tv_alamat.text = pekerjas.pekerja_alamat
                tv_telepon.text = " Telepon : "+ pekerjas.pekerja_telp


            }

            override fun onFailure(call: Call<Pekerja>?, t: Throwable?) {

                Toast.makeText(this@DetailPekerja, "Koneksi Terputus", Toast.LENGTH_LONG).show()

            }

        })

    }

}
