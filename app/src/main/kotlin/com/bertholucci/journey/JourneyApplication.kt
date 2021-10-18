package com.bertholucci.journey

import android.app.Application
import com.bertholucci.journey.data.di.repositoryModule
import com.bertholucci.journey.domain.di.useCaseModule
import com.bertholucci.journey.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class JourneyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JourneyApplication)
            androidLogger()
            modules(
                listOf(
                    repositoryModule,
                    useCaseModule,
                    presentationModule
                )
            )
        }
    }
}