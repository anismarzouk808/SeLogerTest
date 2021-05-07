package com.miled.presentation.ui.models

import com.miled.domain.models.Advertisement
import com.miled.domain.models.ListingResponse


class AdvertisementDataUI {

    val domain by lazy { Domain() }
    val ui by lazy { Ui() }

    class Domain {
        val advertisement = Advertisement(
            1, 4, "Villers-sur-Mer",
            250.0, "url pic", 1500000, "GSL EXPLORE", "Maison - Villa", 8
        )

        private val totalCount = 4

        val listingResponse = ListingResponse(listOf(advertisement), totalCount)
    }

    class Ui {
        val advertisementUI = AdvertisementUI(
            1, 4, "Villers-sur-Mer",
            250.0, "url pic", 1500000, "GSL EXPLORE", "Maison - Villa", 8
        )

        private val totalCount = 4

        val listingResponseUI = ListingResponseUI(listOf(advertisementUI), totalCount)
    }
}