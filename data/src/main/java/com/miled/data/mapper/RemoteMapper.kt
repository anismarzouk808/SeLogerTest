package com.miled.data.mapper

import com.miled.data.entities.AdResponse
import com.miled.data.entities.AdsResponse
import com.miled.domain.models.Ad
import com.miled.domain.models.Ads


/**
 * Manage Mapping from global object API [AdsResponse] to [Ads]
 */
fun AdsResponse.toAds(): Ads {
    val listAd = items?.mapNotNull { it?.toAdOrNull() } ?: emptyList()
    return Ads(
        items = listAd,
        totalCount = totalCount ?: listAd.size
    )
}

/**
 * Manage Mapping from global object API [AdResponse] to [Ad]
 */
fun AdResponse.toAd(): Ad {
    return Ad(
        id = requireNotNull(id),
        bedrooms = bedrooms ?: 0,
        city = requireNotNull(city),
        area = requireNotNull(area),
        url = url,
        price = requireNotNull(price),
        professional = professional.orEmpty(),
        propertyType = propertyType.orEmpty(),
        rooms = requireNotNull(rooms)
    )
}

fun AdResponse.toAdOrNull(): Ad? =
    try {
        toAd()
    } catch (e: Exception) {
        null
    }
