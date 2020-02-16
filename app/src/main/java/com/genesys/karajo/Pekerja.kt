package com.genesys.karajo

import android.os.Parcel
import android.os.Parcelable

class Pekerja() : Parcelable {

    var pekerja_username : String? = ""
    var pekerja_nama : String? = ""
    var pekerja_telp : String? = ""
    var pekerja_alamat : String? = ""
    var pekerja_foto : String? = ""
    var pekerja_fotoktp : String? = ""
    var pekerja_pin : String? = ""
    var pekerja_NIK : String? = ""

    constructor(parcel: Parcel) : this() {
        pekerja_username = parcel.readString()
        pekerja_nama = parcel.readString()
        pekerja_telp = parcel.readString()
        pekerja_alamat = parcel.readString()
        pekerja_foto = parcel.readString()
        pekerja_fotoktp = parcel.readString()
        pekerja_pin = parcel.readString()
        pekerja_NIK = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pekerja_username)
        parcel.writeString(pekerja_nama)
        parcel.writeString(pekerja_telp)
        parcel.writeString(pekerja_alamat)
        parcel.writeString(pekerja_foto)
        parcel.writeString(pekerja_fotoktp)
        parcel.writeString(pekerja_pin)
        parcel.writeString(pekerja_NIK)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pekerja> {
        override fun createFromParcel(parcel: Parcel): Pekerja {
            return Pekerja(parcel)
        }

        override fun newArray(size: Int): Array<Pekerja?> {
            return arrayOfNulls(size)
        }
    }


}