package com.miled.domain.usecase

import com.miled.domain.models.ListingResponse
import com.miled.domain.repository.AdsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetAllAdsUseCase @Inject constructor(private val adsRepository: AdsRepository) {
    operator fun invoke(): Single<ListingResponse> = adsRepository.getAllAds()
}