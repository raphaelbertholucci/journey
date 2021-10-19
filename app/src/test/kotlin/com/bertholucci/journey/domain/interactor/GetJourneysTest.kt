package com.bertholucci.journey.domain.interactor

import com.bertholucci.journey.BaseTest
import com.bertholucci.journey.domain.repository.JourneyRepository
import com.bertholucci.journey.mock.domainMock
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class GetJourneysTest : BaseTest<GetJourneys>() {

    @RelaxedMockK
    private lateinit var repository: JourneyRepository

    override fun init() {
        agent = GetJourneys(repository)
    }

    @Test
    fun getJourneys() = runBlockingTest {
        coEvery { repository.getJourneys() } returns flow {
            emit(domainMock)
        }

        agent(Unit)

        agent.invoke(Unit).collect { result ->
            Assert.assertEquals(domainMock, result)
        }
    }
}