package com.genesys.karajo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService
import kotlinx.android.synthetic.main.activity_tambah_pekerjaan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahPekerjaan : AppCompatActivity() {

    var pekerjaan = Pekerjaan()
    var apiInterface : ApiInterface? = null
    var username = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pekerjaan)

        apiInterface = ApiService.getClient().create(ApiInterface::class.java)
        username = intent.getStringExtra("Username")!!


        btn_tambah_pekerjaan.setOnClickListener {

            var nama = nama_kerjaan.text.toString()
            var deskripsi = deskrpisi_kerjaan.text.toString()
            var mulai = tanggal_mulai.text.toString()
            var selesai = tanggal_selesai.text.toString()
            var gaji = gaji.text.toString()
            var satuan = per.text.toString()
            var telepon = telepon.text.toString()
            var alamat = alamat.text.toString()
            var atasnama = atasnama.text.toString()

            if(nama.isNotEmpty() && deskripsi.isNotEmpty()
                && mulai.isNotEmpty() && selesai.isNotEmpty() && gaji.isNotEmpty()
                && satuan.isNotEmpty() && telepon.isNotEmpty() && alamat.isNotEmpty()){

                pekerjaan.pekerjaan_nama = nama
                pekerjaan.pekerjaan_deskripsi = deskripsi
                pekerjaan.pekerjaan_mulai = mulai
                pekerjaan.pekerjaan_akhir = selesai
                pekerjaan.pekerjaan_gaji = gaji
                pekerjaan.pekerjaan_per = satuan
                pekerjaan.pekerjaan_telp = telepon
                pekerjaan.pekerjaan_alamat = alamat
                pekerjaan.pekerjaan_atasnama = atasnama
                pekerjaan.pekerjaan_foto = ""

                postData(pekerjaan)

            }

        }

    }

    fun postData(pekerjaan: Pekerjaan){

        var pekerjaanCall  = apiInterface?.tambahPekerjaan(
            "insert_pekerjaan",
            pekerjaan.pekerjaan_nama!!,
            pekerjaan.pekerjaan_deskripsi!!,
            pekerjaan.pekerjaan_mulai!!,
            pekerjaan.pekerjaan_akhir!!,
            pekerjaan.pekerjaan_gaji!!,
            pekerjaan.pekerjaan_per!!,
            pekerjaan.pekerjaan_telp!!,
            pekerjaan.pekerjaan_alamat!!,
            pekerjaan.pekerjaan_atasnama!!,
            pekerjaan.pekerjaan_foto!!,
            username

            )

        pekerjaanCall?.enqueue(object : Callback<Pekerjaan>{
            override fun onResponse(call: Call<Pekerjaan>?, response: Response<Pekerjaan>?) {

                Toast.makeText(this@TambahPekerjaan, "Berhasil Di Tambahkan", Toast.LENGTH_LONG).show()
                var intent = Intent(this@TambahPekerjaan, MainActivity::class.java)
                intent.putExtra("Username", username)
                startActivity(intent)


            }

            override fun onFailure(call: Call<Pekerjaan>?, t: Throwable?) {

                Toast.makeText(this@TambahPekerjaan, "Koneksi Terputus", Toast.LENGTH_LONG).show()


            }

        })




    }


}
