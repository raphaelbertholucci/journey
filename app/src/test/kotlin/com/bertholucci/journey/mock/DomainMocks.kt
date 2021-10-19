package com.bertholucci.journey.mock

import com.bertholucci.journey.common.helpers.Response
import com.bertholucci.journey.domain.model.JourneyDomain
import com.bertholucci.journey.presentation.model.Journey

fun success(response: Any) = Response.Success(response)

val domainMock = listOf(
    JourneyDomain(title = "Getting ready for your journey", subtitle = "Ready, set, prep!", 0),
    JourneyDomain(title = "Know your why", subtitle = "Discover your inner motivation", 1),
)

val mock = listOf(
    Journey(title = "Getting ready for your journey", subtitle = "Ready, set, prep!", 0),
    Journey(title = "Know your why", subtitle = "Discover your inner motivation", 1),
)