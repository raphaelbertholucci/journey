package com.bertholucci.journey.presentation.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bertholucci.journey.common.base.BaseActivity
import com.bertholucci.journey.common.extensions.intentToMain
import com.bertholucci.journey.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(::navigateToHome, 2500)
    }

    private fun navigateToHome() {
        startActivity(intentToMain())
    }
}