package com.logical.countries

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This is the main application class for the app.
 * It extends [Application] and is annotated with [HiltAndroidApp] to enable dependency injection with Hilt.
 */
@HiltAndroidApp
class MyApplication : Application()