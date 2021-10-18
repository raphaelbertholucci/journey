package com.bertholucci.journey.domain.di

import com.bertholucci.journey.domain.interactor.GetJourneys
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetJourneys(get()) }
}