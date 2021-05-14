package com.miled.data.remote

import com.miled.data.entities.AdResponse
import com.miled.data.entities.AdsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AdsApiService {

    @GET("listings.json")
    fun getAllAds(): Single<AdsResponse>

    @GET("listings/{listingsId}.json")
    fun getAdsDetail(@Path("listingsId") listingsId: Int): Single<AdResponse>
}