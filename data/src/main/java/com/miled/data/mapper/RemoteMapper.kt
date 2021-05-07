package com.miled.data.mapper

import com.miled.data.entities.AdvertisementDto
import com.miled.data.entities.ListingResponseDto
import com.miled.domain.models.Advertisement
import com.miled.domain.models.ListingResponse

/**
 * Manage Mapping from global object API [AdvertisementDto] to [Advertisement]
 */
fun AdvertisementDto.toDomain(): Advertisement {
    return Advertisement(
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
 * Manage Mapping from global object API [ListingResponseDto] to [ListingResponse]
 */
fun ListingResponseDto.toDomain(): ListingResponse {
    return ListingResponse(
        items = items.map { it.toDomain() },
        totalCount = totalCount
    )
}