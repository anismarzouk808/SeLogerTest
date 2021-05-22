package com.miled.domain.usecase

import com.miled.domain.models.AllModelsTest
import com.miled.domain.repository.AdsRepository
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Test
import java.io.IOException


class GetAdsDetailsUseCaseTest {

    private val adsRepository = mockk<AdsRepository>()

    private val getAdsDetailsUseCase = GetAdsDetailsUseCase(adsRepository)

    @Test
    fun `test success call get advertisement details`() {
        val allModels = AllModelsTest()
        every { adsRepository.getAdDetails(1) } returns Single.just(allModels.advertisementItem)

        getAdsDetailsUseCase(1).test().assertComplete()
        getAdsDetailsUseCase(1).test().assertNoErrors()
    }

    @Test
    fun `test error call get advertisement details`() {
        val error = IOException()
        every { adsRepository.getAdDetails(1) } returns Single.error(error)
        getAdsDetailsUseCase(1).test().assertError(error)
    }
}