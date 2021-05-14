package com.miled.domain.repository

import com.miled.domain.models.Ad
import com.miled.domain.models.Ads
import io.reactivex.Single

interface AdsRepository {
    fun getAds(): Single<Ads>
    fun getAdDetails(adId : Int): Single<Ad>
}