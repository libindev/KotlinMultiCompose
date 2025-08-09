package com.multipatform.project

import android.app.Application
import com.multipatform.project.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class KotlinMultiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@KotlinMultiApp)
            androidLogger()
        }
    }
}