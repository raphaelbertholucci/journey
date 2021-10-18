package com.bertholucci.journey.domain.interactor

import com.bertholucci.journey.domain.UseCase
import com.bertholucci.journey.domain.model.JourneyDomain
import com.bertholucci.journey.domain.repository.JourneyRepository
import kotlinx.coroutines.flow.Flow

class GetJourneys(private val repository: JourneyRepository) :
    UseCase<Any, List<JourneyDomain>>() {
    override fun executeUseCase(requestValues: Any): Flow<List<JourneyDomain>> {
        return repository.getJourneys()
    }
}