package com.bertholucci.journey.presentation.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.bertholucci.journey.R
import com.bertholucci.journey.common.base.BaseActivity
import com.bertholucci.journey.common.helpers.fold
import com.bertholucci.journey.databinding.ActivityMainBinding
import com.bertholucci.journey.presentation.model.Journey
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModel()

    override fun getViewBinding() = ActivityMainBinding.inflate(LayoutInflater.from(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addObservers()
        addListeners()
    }

    private fun addObservers() {
        viewModel.journeys.observe(this) { response ->
            binding.swipe.isRefreshing = false
            response.fold(
                error = ::handleError,
                loading = { display(loading = true) },
                success = {
                    setupUI(it)
                    display(content = true)
                }
            )
        }
    }

    private fun addListeners() {
        binding.swipe.setOnRefreshListener {
            viewModel.getJourneys()
        }
    }

    private fun handleError(throwable: Throwable) {
        throwable.message?.let { Log.i("ERROR", it) }
        display(error = true)
    }

    private fun setupUI(list: List<Journey>) {
        binding.swipe.setColorSchemeColors(ContextCompat.getColor(this, R.color.blue))
        binding.rvItems.adapter = MainAdapter(list) { journey ->
            showDialog(journey)
        }
    }

    private fun showDialog(journey: Journey) {
        AlertDialog.Builder(this).apply {
            setTitle(journey.title)
            setMessage(journey.subtitle)
            setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }
        }.show()
    }

    private fun display(
        content: Boolean = false,
        loading: Boolean = false,
        error: Boolean = false
    ) {
        binding.rvItems.isVisible = content
        binding.loading.isVisible = loading
        binding.errorView.errorGroup.isVisible = error
    }
}