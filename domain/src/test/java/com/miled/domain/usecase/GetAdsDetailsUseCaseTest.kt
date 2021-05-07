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


class GetAdsDetailsUseCaseTest {

    @Mock
    private lateinit var adsRepository: AdsRepository

    private lateinit var getAdsDetailsUseCase: GetAdsDetailsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getAdsDetailsUseCase = GetAdsDetailsUseCase(adsRepository)
    }

    @Test
    fun `test success call get advertisement details`() {
        val allmodels = AllModelsTest()
        whenever(adsRepository.getAdsDetails(1)).thenReturn(
            Single.just(allmodels.advertisementItem)
        )

        getAdsDetailsUseCase(1).test().assertComplete()
        getAdsDetailsUseCase(1).test().assertNoErrors()
    }

    @Test
    fun `test error call get advertisement details`() {
        val error = IOException()
        whenever(adsRepository.getAdsDetails(1)).thenReturn(Single.error(error))
        getAdsDetailsUseCase(1).test().assertError(error)
    }
}