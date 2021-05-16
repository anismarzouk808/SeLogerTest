package com.miled.domain.usecase

import com.miled.domain.models.AllModelsTest
import com.miled.domain.repository.AdsRepository
import com.miled.domain.utils.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.io.IOException

class GetAllAdsUseCaseTest {

    @Mock
    private lateinit var adsRepository: AdsRepository

    private lateinit var getAllAdsUseCase: GetAllAdsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getAllAdsUseCase = GetAllAdsUseCase(adsRepository)
    }

    @Test
    fun `test success call get all advertisement`() {
        val allmodels = AllModelsTest()
        whenever(adsRepository.getAds()).thenReturn(
            Single.just(allmodels.listingResponse)
        )

        getAllAdsUseCase().test().assertComplete()
        getAllAdsUseCase().test().assertNoErrors()
    }

    @Test
    fun `test error call get all advertisement`() {
        val error = IOException()
        whenever(adsRepository.getAds()).thenReturn(Single.error(error))
        getAllAdsUseCase().test().assertError(error)
    }
}