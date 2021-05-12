package com.miled.data.remote

import com.miled.data.mapper.toDomain
import com.miled.domain.models.Advertisement
import com.miled.domain.models.ListingResponse
import com.miled.domain.repository.AdsRepository
import io.reactivex.Single
import javax.inject.Inject

class AdsRepositoryImp @Inject constructor(private val adsApiService: AdsApiService) :
    AdsRepository {

    override fun getAllAds(): Single<ListingResponse> {
        return adsApiService.getAllAds().map { it.toDomain() }
    }

    override fun getAdsDetails(advertisementId: Int): Single<Advertisement> {
        return adsApiService.getAdsDetail(advertisementId).map { it.toDomain() }
    }
}
