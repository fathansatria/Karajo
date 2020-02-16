package com.genesys.karajo.Network

import com.genesys.karajo.Pekerja
import com.genesys.karajo.Pekerjaan
import com.genesys.karajo.Perekrut
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("KarajoAPI")
    fun getAllPekerjaan(
        @Query("action") action : String,
        @Query("username_perekrut") username : String) : Call<List<Pekerjaan>>

    @GET("KarajoAPI")
    fun getAllPekerja(
        @Query("action") action : String,
        @Query("pekerjaan_id") id : String) : Call<List<Pekerja>>

    @GET("KarajoAPI")
    fun getPekerjaan(
        @Query("action") action : String,
        @Query("id_pekerjaan") id : String) : Call<Pekerjaan>

    @GET("KarajoAPI")
    fun getPekerja(
        @Query("action") action : String,
        @Query("pekerja_username") username : String) : Call<Pekerja>

    @GET("KarajoAPI")
    fun tambahPekerjaan(
        @Query("action") action : String,
        @Query("pekerjaan_nama") nama_kerjaan : String,
        @Query("pekerjaan_deskripsi") deskripsi : String,
        @Query("pekerjaan_mulai") tanggal_mulai : String,
        @Query("pekerjaan_akhir") tanggal_akhir : String,
        @Query("pekerjaan_gaji") gaji : String,
        @Query("pekerjaan_per") satuan : String,
        @Query("pekerjaan_telp") telepon : String,
        @Query("pekerjaan_alamat") alamat : String,
        @Query("pekerjaan_atasnama") atasnama : String,
        @Query("pekerjaan_foto") foto : String,
        @Query("perekrut_username") username : String

        ) : Call<Pekerjaan>

    @GET("KarajoAPI")
    fun getLoginPerekrut(
        @Query("action") action : String,
        @Query("perekrut_username") username : String,
        @Query("perekrut_pin") pin : String
        ) : Call<List<Perekrut>>

    @GET("KarajoAPI")
    fun daftarPerekrut(
        @Query("action") action : String,
        @Query("perekrut_nama") nama : String,
        @Query("perekrut_nik") nik : String,
        @Query("perekrut_telp") telp : String,
        @Query("perekrut_alamat") alamat : String,
        @Query("perekrut_username") username : String,
        @Query("perekrut_pin") pin : String,
        @Query("perekrut_foto") foto : String,
        @Query("perekrut_fotoktp") ktp : String

    ) : Call<Perekrut>

    @GET("KarajoAPI")
    fun getAllPelamar(
        @Query("action") action : String,
        @Query("perekrut_username") username : String,
        @Query("pekerjaan_id") pekerjaan : String

        ) : Call<List<Pekerja>>











}