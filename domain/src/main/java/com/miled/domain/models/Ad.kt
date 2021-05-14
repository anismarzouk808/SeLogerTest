package com.miled.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ad(
    val id: Int = 0,
    val bedrooms: Int = 0,
    val city: String = String(),
    val area: Double = 0.0,
    val url: String? = String(),
    val price: Int = 0,
    val professional: String,
    val propertyType: String,
    val rooms: Int = 0
) : Parcelable

@Parcelize
data class Ads(
    val items: List<Ad>,
    val totalCount: Int,
) : Parcelable