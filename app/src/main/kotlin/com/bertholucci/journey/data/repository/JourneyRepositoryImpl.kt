package com.bertholucci.journey.data.repository

import android.content.Context
import com.bertholucci.journey.common.helpers.Converters.getJson
import com.bertholucci.journey.data.mapper.JourneysResponseMapper
import com.bertholucci.journey.data.model.JourneyResponse
import com.bertholucci.journey.domain.model.JourneyDomain
import com.bertholucci.journey.domain.repository.JourneyRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JourneyRepositoryImpl(private val context: Context) : JourneyRepository {
    override fun getJourneys(): Flow<List<JourneyDomain>> {
        return flow {
            delay(1500L)
            val json: List<JourneyResponse> = getJson(context, "data.json")
            emit(JourneysResponseMapper().mapFromDomainList(json))
        }
    }
}