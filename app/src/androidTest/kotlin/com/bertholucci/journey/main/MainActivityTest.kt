package com.bertholucci.journey.main

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun showCorrectTextsWithoutArgs() {
        setupView {
        } execute {
        } check {
            checkRecycler()
        }
    }
}