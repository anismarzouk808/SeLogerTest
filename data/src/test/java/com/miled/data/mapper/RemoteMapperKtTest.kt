package com.miled.data.mapper

import com.miled.data.entity.AdvertismentData
import org.amshove.kluent.`should be equal to`
import org.junit.Before
import org.junit.Test

class RemoteMapperKtTest {

    private lateinit var data: AdvertismentData

    @Before
    fun setUp() {
        data = AdvertismentData()
    }

    @Test
    fun `map data to domain`() {
        // Given
        val expected = data.domain.listingResponse
        // When
        val domain = data.fromServer.listingResponseDto.toDomain()
        // Then
        domain `should be equal to` expected
    }
}