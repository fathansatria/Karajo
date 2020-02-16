package com.genesys.karajo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.genesys.karajo.Network.ApiInterface
import com.genesys.karajo.Network.ApiService
import kotlinx.android.synthetic.main.item_pekerjaan.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PekerjaanAdapter(var context: Context, var listPekerjaan : ArrayList<Pekerjaan>) : RecyclerView.Adapter<PekerjaanAdapter.ViewHolder>() {


    var data = ApiService.getClient().create(ApiInterface::class.java)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var callPelamar = data.getAllPelamar("get_all_pekerja",listPekerjaan[position].perekrut_username!!, listPekerjaan[position].pekerjaan_id!!)

        callPelamar.enqueue(object : Callback<List<Pekerja>> {
            override fun onResponse(call: Call<List<Pekerja>>, response: Response<List<Pekerja>>) {
                holder.et_jumlah_pelamar.text = "Terdapat "+ (response?.body() as ArrayList<Pekerja>).size +  "Pelamar"
            }

            override fun onFailure(call: Call<List<Pekerja>>, t: Throwable) {

                holder.et_jumlah_pelamar.text = "Pelamar Tidak diketahui"

            }

        })

        holder.et_nama_kerjaan.text = listPekerjaan[position].pekerjaan_nama

        holder.ll_item_pekerjaan.setOnClickListener {

            val intent = Intent(context, DaftarPekerja::class.java)
            intent.putExtra("id_pekerjaan", listPekerjaan[position].pekerjaan_id)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return listPekerjaan.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pekerjaan, parent, false))

    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val et_nama_kerjaan = view.et_nama_kerjaan
        val et_jumlah_pelamar = view.et_jumlah_pelamar
        val ll_item_pekerjaan = view.item_pekerjaan

    }



}
