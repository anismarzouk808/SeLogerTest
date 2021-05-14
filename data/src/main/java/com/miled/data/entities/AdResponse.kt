package com.miled.data.entities

import com.google.gson.annotations.SerializedName

data class AdResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("bedrooms")
    val bedrooms: Int?,

    @SerializedName("city")
    val city: String?,

    @SerializedName("area")
    val area: Double?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("price")
    val price: Int?,

    @SerializedName("professional")
    val professional: String?,

    @SerializedName("propertyType")
    val propertyType: String?,

    @SerializedName("rooms")
    val rooms: Int?
)

data class AdsResponse(
    @SerializedName("items")
    val items: List<AdResponse?>?,

    @SerializedName("totalCount")
    val totalCount: Int?,
)