package com.genesys.karajo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_signup_fragment1.view.*


class SignupFragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentView = inflater.inflate(R.layout.fragment_signup_fragment1, container, false)

//        (activity as SignUpActivity).perekrut.perekrut_nama = fragmentView.et_nama.text.toString()
//        (activity as SignUpActivity).perekrut.perekrut_NIK = fragmentView.et_nik.text.toString()
//        (activity as SignUpActivity).perekrut.perekrut_telp = fragmentView.et_telepon.text.toString()
//        (activity as SignUpActivity).perekrut.perekrut_username = fragmentView.et_username.text.toString()
//        (activity as SignUpActivity).perekrut.perekrut_pin = fragmentView.et_pin.text.toString()


        fragmentView.btn_selanjutnya.setOnClickListener {

            (activity as SignUpActivity).perekrut.perekrut_nama = fragmentView.et_nama.text.toString()
            (activity as SignUpActivity).perekrut.perekrut_NIK = fragmentView.et_nik.text.toString()
            (activity as SignUpActivity).perekrut.perekrut_telp = fragmentView.et_telepon.text.toString()
            (activity as SignUpActivity).perekrut.perekrut_username = fragmentView.et_username.text.toString()
            (activity as SignUpActivity).perekrut.perekrut_pin = fragmentView.et_pin.text.toString()

            (activity as SignUpActivity).perekrut_nama = fragmentView.et_nama.text.toString()
            (activity as SignUpActivity).perekrut_nik = fragmentView.et_nik.text.toString()
            (activity as SignUpActivity).perekrut_telp = fragmentView.et_telepon.text.toString()
            (activity as SignUpActivity).perekrut_username = fragmentView.et_username.text.toString()
            (activity as SignUpActivity).perekrut_pin = fragmentView.et_pin.text.toString()

            (activity as SignUpActivity).changeFragment(SignupFragment2())
        }

        return fragmentView
    }



}
