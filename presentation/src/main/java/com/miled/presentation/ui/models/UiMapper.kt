package com.miled.presentation.ui.models

import com.miled.domain.models.Advertisement
import com.miled.domain.models.ListingResponse

/**
 * Manage Mapping from domain [Advertisement] to [AdvertisementUI]
 */
fun Advertisement.toUi(): AdvertisementUI {
    return AdvertisementUI(
        id = id,
        bedrooms = bedrooms,
        city = city,
        area = area,
        url = url,
        price = price,
        professional = professional,
        propertyType = propertyType,
        rooms = rooms
    )
}

/**
 * Manage Mapping from domain [ListingResponse] to [ListingResponseUI]
 */
fun ListingResponse.toUi(): ListingResponseUI {
    return ListingResponseUI(
        items = items.map { it.toUi() },
        totalCount = totalCount
    )
}