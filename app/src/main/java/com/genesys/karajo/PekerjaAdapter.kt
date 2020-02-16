package com.genesys.karajo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService
import kotlinx.android.synthetic.main.activity_detail_pekerja.*
import kotlinx.android.synthetic.main.item_pekerja.view.*

class PekerjaAdapter(var context: Context, var listPekerja : ArrayList<Pekerja>) : RecyclerView.Adapter<PekerjaAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.tv_nama.text = "Nama : " + listPekerja[position].pekerja_nama
        holder.tv_nik.text = "NIK : " + listPekerja[position].pekerja_NIK

        Glide.with(context).load(listPekerja[position].pekerja_foto).into(holder.iv_foto)


        holder.ll_item_pekerjaan.setOnClickListener {

            val intent = Intent(context, DetailPekerja::class.java)
            intent.putExtra("pekerja_username", listPekerja[position].pekerja_username)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return listPekerja.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pekerja, parent, false))

    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val tv_nama = view.tv_nama
        val tv_nik = view.tv_nik
        val iv_foto = view.iv_foto
        val ll_item_pekerjaan = view.ll_item_pekerja

    }



}
