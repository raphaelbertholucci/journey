package com.bertholucci.journey.data.mapper

import com.bertholucci.journey.common.base.BaseMapper
import com.bertholucci.journey.data.model.JourneyResponse
import com.bertholucci.journey.domain.model.JourneyDomain

class JourneysResponseMapper : BaseMapper<JourneyResponse, JourneyDomain> {

    override fun mapFromDomain(domain: JourneyDomain): JourneyResponse {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: JourneyResponse): JourneyDomain =
        JourneyDomain(title = model.title, subtitle = model.subtitle, day = model.day)

    fun mapFromDomainList(list: List<JourneyResponse>?) = list?.map {
        mapToDomain(it)
    } ?: emptyList()
}