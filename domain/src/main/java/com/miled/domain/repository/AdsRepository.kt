package com.miled.domain.repository

import com.miled.domain.models.Advertisement
import com.miled.domain.models.ListingResponse
import io.reactivex.Single

interface AdsRepository {
    fun getAllAds(): Single<ListingResponse>
    fun getAdsDetails(advertisementId : Int): Single<Advertisement>
}