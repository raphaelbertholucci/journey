package com.bertholucci.journey.common.extensions

import android.content.Context
import android.content.Intent

private const val ACTION_MAIN = "MAIN"

fun Context.intentForAction(action: String, vararg flags: Int) = Intent().apply {
    setAction("$packageName.$action")
    flags.forEach { addFlags(it) }
}

fun Context.intentToMain() = intentForAction(ACTION_MAIN)