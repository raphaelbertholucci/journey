package com.bertholucci.journey.presentation.mapper

import com.bertholucci.journey.common.base.BaseMapper
import com.bertholucci.journey.domain.model.JourneyDomain
import com.bertholucci.journey.presentation.model.Journey

class JourneysMapper : BaseMapper<Journey, JourneyDomain> {

    override fun mapFromDomain(domain: JourneyDomain) =
        Journey(title = domain.title, subtitle = domain.subtitle, day = domain.day)

    override fun mapToDomain(model: Journey): JourneyDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    fun mapFromDomainList(list: List<JourneyDomain>?) = list?.map {
        mapFromDomain(it)
    } ?: emptyList()
}