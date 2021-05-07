package com.miled.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Advertisement(
    val id: Int = 0,
    val bedrooms: Int = 0,
    val city: String = String(),
    val area: Double = 0.0,
    val url: String? = String(),
    val price: Int = 0,
    val professional: String = String(),
    val propertyType: String = String(),
    val rooms: Int = 0
) : Parcelable

@Parcelize
data class ListingResponse(
    val items: List<Advertisement>,
    val totalCount: Int,
) : Parcelable