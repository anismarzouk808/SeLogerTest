package com.miled.domain.usecase

import com.miled.domain.models.Ads
import com.miled.domain.repository.AdsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetAllAdsUseCase @Inject constructor(private val adsRepository: AdsRepository) {
    operator fun invoke(): Single<Ads> = adsRepository.getAds()
}