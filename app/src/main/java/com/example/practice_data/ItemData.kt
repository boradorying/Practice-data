package com.example.practice_data


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemData (
    var name: String,
    var phone: String,
    var photo: Int,
    var description: String,
    var isHeart: Boolean
) : Parcelable




