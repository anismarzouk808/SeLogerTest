package com.miled.data.entity

import com.miled.data.entities.AdvertisementDto
import com.miled.data.entities.ListingResponseDto
import com.miled.domain.models.Advertisement
import com.miled.domain.models.ListingResponse


class AdvertismentData {

    val fromServer by lazy { FromServer() }
    val domain by lazy { Domain() }

    class FromServer {
        val advertisementDto = AdvertisementDto(
            1, 4, "Villers-sur-Mer",
            250.0, "url pic", 1500000, "GSL EXPLORE", "Maison - Villa", 8
        )

        private val totalCount = 4

        val listingResponseDto = ListingResponseDto(listOf(advertisementDto), totalCount)
    }

    class Domain {
        val advertisement = Advertisement(
            1, 4, "Villers-sur-Mer",
            250.0, "url pic", 1500000, "GSL EXPLORE", "Maison - Villa", 8
        )

        private val totalCount = 4

        val listingResponse = ListingResponse(listOf(advertisement), totalCount)
    }
}