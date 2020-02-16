package com.genesys.karajo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    var perekrut = Perekrut()
    var perekrut_nama = ""
    var perekrut_nik = ""
    var perekrut_telp = ""
    var perekrut_username = ""
    var perekrut_pin = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        changeFragment(SignupFragment1())

        tv_masuk.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))

        }

    }


    fun changeFragment(current : Fragment){

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragments_container,current)
        ft.commit()

    }
}
