package com.miled.domain.usecase

import com.miled.domain.models.AllModelsTest
import com.miled.domain.repository.AdsRepository
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Test
import java.io.IOException

class GetAllAdsUseCaseTest {

    private val adsRepository = mockk<AdsRepository>()

    private val getAllAdsUseCase = GetAllAdsUseCase(adsRepository)

    @Test
    fun `test success call get all advertisement`() {
        val allModels = AllModelsTest()
        every { adsRepository.getAds() } returns Single.just(allModels.listingResponse)


        getAllAdsUseCase().test().assertComplete()
        getAllAdsUseCase().test().assertNoErrors()
    }

    @Test
    fun `test error call get all advertisement`() {
        val error = IOException()
        every { adsRepository.getAds() } returns Single.error(error)
        getAllAdsUseCase().test().assertError(error)
    }
}