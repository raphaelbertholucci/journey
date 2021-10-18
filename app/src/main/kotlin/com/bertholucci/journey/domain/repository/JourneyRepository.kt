package com.bertholucci.journey.domain.repository

import com.bertholucci.journey.domain.model.JourneyDomain
import kotlinx.coroutines.flow.Flow

interface JourneyRepository {
    fun getJourneys(): Flow<List<JourneyDomain>>
}