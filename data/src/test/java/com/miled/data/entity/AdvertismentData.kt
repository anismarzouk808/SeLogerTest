package com.miled.data.entity

import com.miled.data.entities.AdResponse
import com.miled.data.entities.AdsResponse
import com.miled.domain.models.Ad
import com.miled.domain.models.Ads


class AdvertismentData {

    val fromServer by lazy { FromServer() }
    val domain by lazy { Domain() }

    class FromServer {
        val advertisementDto = AdResponse(
            1, 4, "Villers-sur-Mer",
            250.0, "url pic", 1500000, "GSL EXPLORE", "Maison - Villa", 8
        )

        private val totalCount = 4

        val listingResponseDto = AdsResponse(listOf(advertisementDto), totalCount)
    }

    class Domain {
        val advertisement = Ad(
            1, 4, "Villers-sur-Mer",
            250.0, "url pic", 1500000, "GSL EXPLORE", "Maison - Villa", 8
        )

        private val totalCount = 4

        val listingResponse = Ads(listOf(advertisement), totalCount)
    }
}