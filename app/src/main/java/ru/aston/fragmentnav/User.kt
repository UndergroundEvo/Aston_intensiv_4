package ru.aston.fragmentnav

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var id: Int,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var photoUrl: String
) : Parcelable