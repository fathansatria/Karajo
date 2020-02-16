package com.genesys.karajo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService

import kotlinx.android.synthetic.main.fragment_signup_fragment2.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignupFragment2 : Fragment() {

    var apiInterface : ApiInterface? = null
    var perekrut2 = Perekrut()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val fragmentView = inflater.inflate(R.layout.fragment_signup_fragment2, container, false)
        apiInterface = ApiService.getClient().create(ApiInterface::class.java)



        fragmentView.tambah_Foto.setOnClickListener { }
        fragmentView.tambah_Foto_Ktp.setOnClickListener { }

        perekrut2 = (activity as SignUpActivity).perekrut

        fragmentView.btn_daftar.setOnClickListener {

            (activity as SignUpActivity).perekrut.perekrut_alamat = fragmentView.et_alamat.text.toString()


            if(perekrut2.perekrut_nama!!.isNotEmpty() && perekrut2.perekrut_NIK!!.isNotEmpty()
                && perekrut2.perekrut_telp!!.isNotEmpty() && perekrut2.perekrut_alamat!!.isNotEmpty()
                && perekrut2.perekrut_pin!!.isNotEmpty() && perekrut2.perekrut_username!!.isNotEmpty()){

                daftarAkun(perekrut2)

            }
            else{

                Toast.makeText(activity, " Mohon lengkapi data ", Toast.LENGTH_LONG).show()


            }

        }


        return fragmentView
    }

    fun daftarAkun(perekrut: Perekrut){

        var callDaftar = apiInterface?.daftarPerekrut("daftar_perekrut",perekrut.perekrut_nama!!, perekrut.perekrut_NIK!!, perekrut.perekrut_telp!!,
            perekrut.perekrut_alamat!!, perekrut.perekrut_username!!,perekrut.perekrut_pin!!, perekrut.perekrut_foto!!, perekrut.perekrut_fotoktp!!)

        callDaftar?.enqueue(object : Callback<Perekrut>{
            override fun onResponse(call: Call<Perekrut>?, response: Response<Perekrut>?) {

                Toast.makeText(activity, "Pendaftaran Berhasil", Toast.LENGTH_LONG).show()
                startActivity(Intent(activity, LoginActivity::class.java))

            }

            override fun onFailure(call: Call<Perekrut>?, t: Throwable?) {

                Toast.makeText(activity, "Koneksi Terputus", Toast.LENGTH_LONG).show()


            }

        })




    }



}
