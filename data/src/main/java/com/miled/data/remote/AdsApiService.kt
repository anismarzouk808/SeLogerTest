package com.miled.data.remote

import com.miled.data.entities.AdvertisementDto
import com.miled.data.entities.ListingResponseDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AdsApiService {

    @GET("listings.json")
    fun getAllAds(): Single<ListingResponseDto>

    @GET("listings/{listingsId}.json")
    fun getAdsDetail(@Path("listingsId") listingsId: Int): Single<AdvertisementDto>
}