package com.miled.data.remote

import com.miled.data.entity.AdvertismentData
import com.miled.domain.repository.AdsRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class AdsRepositoryTest {

    private lateinit var apiService: AdsApiService
    private lateinit var data: AdvertismentData
    private lateinit var repository: AdsRepository

    @Before
    fun setUp() {
        apiService = mock()
        data = AdvertismentData()
        repository = AdsRepositoryImp(apiService)
    }


    @Test
    fun `get All Advertisement`() {
        // Given
        Mockito.`when`(apiService.getAllAds())
            .thenAnswer { Single.just(data.fromServer.listingResponseDto) }
        // When
        val observer = repository.getAllAds().test()
        // Then
        observer.assertComplete()
            .assertNoErrors()
            .assertValueCount(1)
            .assertValue(data.domain.listingResponse)
    }

    @Test
    fun `get Advertisement Detail`() {
        // Given
        Mockito.`when`(apiService.getAdsDetail(1))
            .thenAnswer { Single.just(data.fromServer.advertisementDto) }
        // When
        val observer = repository.getAdsDetails(1).test()
        // Then
        observer.assertComplete()
            .assertNoErrors()
            .assertValueCount(1)
            .assertValue(data.domain.advertisement)
    }
}