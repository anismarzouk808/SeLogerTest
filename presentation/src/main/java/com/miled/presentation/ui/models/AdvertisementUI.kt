package com.miled.presentation.ui.models

data class AdvertisementUI(
    val id: Int,
    val bedrooms: Int,
    val city: String,
    val area: Double,
    val url: String?,
    val price: Int,
    val professional: String,
    val propertyType: String,
    val rooms: Int
)

data class ListingResponseUI(
    val items: List<AdvertisementUI>,
    val totalCount: Int,
)