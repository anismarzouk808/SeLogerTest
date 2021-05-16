package com.miled.domain.usecase

import com.miled.domain.models.Ad
import com.miled.domain.repository.AdsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetAdsDetailsUseCase @Inject constructor(private val adsRepository: AdsRepository) {

    operator fun invoke(id: Int): Single<Ad> = adsRepository.getAdDetails(id)
}