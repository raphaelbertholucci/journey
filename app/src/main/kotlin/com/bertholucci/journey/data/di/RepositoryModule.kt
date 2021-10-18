package com.bertholucci.journey.data.di

import com.bertholucci.journey.data.repository.JourneyRepositoryImpl
import com.bertholucci.journey.domain.repository.JourneyRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<JourneyRepository> { JourneyRepositoryImpl(androidContext()) }
}