package com.pere.user.almoznino

import android.app.Application
import timber.log.Timber

/**
 * Created by Yoav G on 25/11/2018.
 */
class AlmozApp : Application() {


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}