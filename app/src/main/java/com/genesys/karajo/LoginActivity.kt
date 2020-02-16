package com.genesys.karajo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_signup_fragment2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var username : String? = ""
    var pin : String? = ""
    var loginSuccess = false
    var apiInterface : ApiInterface? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiInterface = ApiService.getClient().create(ApiInterface::class.java)

        tv_daftar.setOnClickListener {

            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }


        btn_masuk.setOnClickListener {

            username = et_username.text.toString()
            pin = et_pin.text.toString()

            if(username!!.isNotEmpty() && pin!!.isNotEmpty()){

                Log.i("usename", username)
                Log.i("pin", pin)


                checkLogin(username!!, pin!!)


            }
            else{

                Toast.makeText(this@LoginActivity, "Pastikan semua data terisi",Toast.LENGTH_LONG).show()

            }

        }



    }

    fun checkLogin(username : String, pin : String){

        val callListPerekrut  = apiInterface?.getLoginPerekrut("login_perekrut", username,pin)
        callListPerekrut?.enqueue(object : Callback<List<Perekrut>>{
            override fun onResponse(
                call: Call<List<Perekrut>>?,
                response: Response<List<Perekrut>>?
            ) {

                var list = response?.body() as ArrayList<Perekrut>
                if (list.isNotEmpty()){


                    var intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("Username",username)
                    startActivity(intent)

                }
                else{
                    Toast.makeText(this@LoginActivity, "Login gagal, cek kembali Username dan Pin",Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<List<Perekrut>>?, t: Throwable?) {

                Toast.makeText(this@LoginActivity, "Login gagal, cek kembali Username dan Pin" ,Toast.LENGTH_LONG).show()

            }

        })

    }



}
