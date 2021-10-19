package com.bertholucci.journey.presentation.ui.main

import com.bertholucci.journey.BaseTest
import com.bertholucci.journey.domain.interactor.GetJourneys
import com.bertholucci.journey.mock.domainMock
import com.bertholucci.journey.mock.success
import com.bertholucci.journey.presentation.mapper.JourneysMapper
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest : BaseTest<MainViewModel>() {

    @RelaxedMockK
    private lateinit var getJourneys: GetJourneys

    override fun init() {
        agent = MainViewModel(getJourneys)
    }

    @Test
    fun getJourneys() = runBlockingTest {
        coEvery { getJourneys(any()) } returns flow {
            emit(domainMock)
        }

        agent.getJourneys()

        agent.journeys.observeForever { result ->
            assertEquals(success(JourneysMapper().mapFromDomainList(domainMock)), result)
        }
    }
}