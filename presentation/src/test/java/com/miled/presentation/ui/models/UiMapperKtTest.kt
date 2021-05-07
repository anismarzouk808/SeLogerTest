package com.miled.presentation.ui.models

import org.amshove.kluent.`should be equal to`
import org.junit.Before
import org.junit.Test


class UiMapperKtTest {
    private lateinit var data: AdvertisementDataUI

    @Before
    fun setUp() {
        data = AdvertisementDataUI()
    }

    @Test
    fun `map domain to ui`() {
        //Given
        val expected = data.ui.listingResponseUI
        // When
        val ui = data.domain.listingResponse.toUi()
        // Then
        ui `should be equal to` expected
    }
}