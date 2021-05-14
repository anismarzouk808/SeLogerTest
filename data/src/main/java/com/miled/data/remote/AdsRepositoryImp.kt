package com.miled.data.remote

import com.miled.data.mapper.toAd
import com.miled.data.mapper.toAds
import com.miled.domain.models.Ad
import com.miled.domain.models.Ads
import com.miled.domain.repository.AdsRepository
import io.reactivex.Single
import javax.inject.Inject

class AdsRepositoryImp @Inject constructor(private val adsApiService: AdsApiService) :
    AdsRepository {

    override fun getAds(): Single<Ads> {
        return adsApiService.getAllAds().map { it.toAds() }
    }

    override fun getAdDetails(adId: Int): Single<Ad> {
        return adsApiService.getAdsDetail(adId).map { it.toAd() }
    }
}
