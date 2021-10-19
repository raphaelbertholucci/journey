package com.bertholucci.journey.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bertholucci.journey.common.extensions.hideLoading
import com.bertholucci.journey.common.extensions.showLoading
import com.bertholucci.journey.common.helpers.Response
import com.bertholucci.journey.domain.interactor.GetJourneys
import com.bertholucci.journey.presentation.mapper.JourneysMapper
import com.bertholucci.journey.presentation.model.Journey
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class MainViewModel(private val getJourneys: GetJourneys) : ViewModel() {

    private val _journeys = MutableLiveData<Response<List<Journey>>>()
    val journeys: LiveData<Response<List<Journey>>>
        get() = _journeys

    init {
        getJourneys()
    }

    fun getJourneys() {
        getJourneys(Unit)
            .onStart { _journeys.showLoading() }
            .onCompletion { _journeys.hideLoading() }
            .map { _journeys.postValue(Response.Success(JourneysMapper().mapFromDomainList(it))) }
            .catch { _journeys.postValue(Response.Failure(it)) }
            .launchIn(viewModelScope)
    }
}