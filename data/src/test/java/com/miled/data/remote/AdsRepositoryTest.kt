package com.miled.data.remote

import com.miled.data.entity.AdvertismentData
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Test


class AdsRepositoryTest {

    private val apiService = mockk<AdsApiService>()
    private val repository = AdsRepositoryImp(apiService)

    @Test
    fun `get All Advertisement`() {
        // Given
        val response = AdvertismentData().fromServer.listingResponseDto
        every { apiService.getAllAds() } returns Single.just(response)

        // When
        val observer = repository.getAds().test()

        // Then
        observer.assertComplete()
            .assertNoErrors()
            .assertValueCount(1)
            .assertValue(AdvertismentData().domain.listingResponse)
    }

    @Test
    fun `get Advertisement Detail`() {
        // Given
        every { apiService.getAdsDetail(1) } returns Single.just(AdvertismentData().fromServer.advertisementDto)
        // When
        val observer = repository.getAdDetails(1).test()
        // Then
        observer.assertComplete()
            .assertNoErrors()
            .assertValueCount(1)
            .assertValue(AdvertismentData().domain.advertisement)
    }
}