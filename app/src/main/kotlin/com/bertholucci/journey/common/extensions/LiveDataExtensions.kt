package com.bertholucci.journey.common.extensions

import androidx.lifecycle.MutableLiveData
import com.bertholucci.journey.common.helpers.Response

fun <V> MutableLiveData<Response<V>>.showLoading() {
    value = Response.Loading(true)
}

fun <V> MutableLiveData<Response<V>>.hideLoading() {
    value = Response.Loading(false)
}