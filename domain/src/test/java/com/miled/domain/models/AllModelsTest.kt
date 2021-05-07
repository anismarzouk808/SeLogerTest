package com.miled.domain.models

class AllModelsTest {

    val advertisementItem = Advertisement(
        1, 4, "Villers-sur-Mer",
        250.0, "url pic", 1500000, "GSL EXPLORE", "Maison - Villa", 8
    )

    private val totalCount = 4

    val listingResponse = ListingResponse(listOf(advertisementItem), totalCount)
}