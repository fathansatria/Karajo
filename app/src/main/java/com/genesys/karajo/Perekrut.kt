package com.genesys.karajo

import android.os.Parcel
import android.os.Parcelable

class Perekrut() : Parcelable {

    var perekrut_nama : String? = ""
    var perekrut_NIK : String? = ""
    var perekrut_telp : String? = ""
    var perekrut_username : String? = ""
    var perekrut_pin : String? = ""
    var perekrut_alamat : String? = ""
    var perekrut_foto : String? = ""
    var perekrut_fotoktp : String? = ""

    constructor(parcel: Parcel) : this() {
        perekrut_nama = parcel.readString()
        perekrut_NIK = parcel.readString()
        perekrut_telp = parcel.readString()
        perekrut_username = parcel.readString()
        perekrut_pin = parcel.readString()
        perekrut_alamat = parcel.readString()
        perekrut_foto = parcel.readString()
        perekrut_fotoktp = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(perekrut_nama)
        parcel.writeString(perekrut_NIK)
        parcel.writeString(perekrut_telp)
        parcel.writeString(perekrut_username)
        parcel.writeString(perekrut_pin)
        parcel.writeString(perekrut_alamat)
        parcel.writeString(perekrut_foto)
        parcel.writeString(perekrut_fotoktp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Perekrut> {
        override fun createFromParcel(parcel: Parcel): Perekrut {
            return Perekrut(parcel)
        }

        override fun newArray(size: Int): Array<Perekrut?> {
            return arrayOfNulls(size)
        }
    }
}