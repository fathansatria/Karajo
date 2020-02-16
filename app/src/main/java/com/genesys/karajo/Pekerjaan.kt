package com.genesys.karajo

import android.os.Parcel
import android.os.Parcelable

class Pekerjaan() : Parcelable {

    var pekerjaan_id : String? = ""
    var pekerjaan_nama : String? = ""
    var pekerjaan_atasnama: String? = ""
    var pekerjaan_gaji : String? = ""
    var pekerjaan_per : String? = ""
    var pekerjaan_deskripsi : String? = ""
    var pekerjaan_alamat : String? = ""
    var pekerjaan_telp : String? = ""
    var pekerjaan_mulai : String? = ""
    var pekerjaan_akhir : String? = ""
    var pekerjaan_foto : String? = ""
    var perekrut_username : String? = ""

    constructor(parcel: Parcel) : this() {
        pekerjaan_id = parcel.readString()
        pekerjaan_nama = parcel.readString()
        pekerjaan_atasnama = parcel.readString()
        pekerjaan_gaji = parcel.readString()
        pekerjaan_per = parcel.readString()
        pekerjaan_deskripsi = parcel.readString()
        pekerjaan_alamat = parcel.readString()
        pekerjaan_telp = parcel.readString()
        pekerjaan_mulai = parcel.readString()
        pekerjaan_akhir = parcel.readString()
        pekerjaan_foto = parcel.readString()
        perekrut_username = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pekerjaan_id)
        parcel.writeString(pekerjaan_nama)
        parcel.writeString(pekerjaan_atasnama)
        parcel.writeString(pekerjaan_gaji)
        parcel.writeString(pekerjaan_per)
        parcel.writeString(pekerjaan_deskripsi)
        parcel.writeString(pekerjaan_alamat)
        parcel.writeString(pekerjaan_telp)
        parcel.writeString(pekerjaan_mulai)
        parcel.writeString(pekerjaan_akhir)
        parcel.writeString(pekerjaan_foto)
        parcel.writeString(perekrut_username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pekerjaan> {
        override fun createFromParcel(parcel: Parcel): Pekerjaan {
            return Pekerjaan(parcel)
        }

        override fun newArray(size: Int): Array<Pekerjaan?> {
            return arrayOfNulls(size)
        }
    }


}