package com.miled.domain.usecase

import com.miled.domain.models.Advertisement
import com.miled.domain.repository.AdsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetAdsDetailsUseCase @Inject constructor(private val adsRepository: AdsRepository) {
    operator fun invoke(id: Int): Single<Advertisement> = adsRepository.getAdsDetails(id)
}