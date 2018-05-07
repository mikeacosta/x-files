package net.acosta.mike.xfiles

import android.app.Application
import net.acosta.mike.xfiles.di.dataModule
import net.acosta.mike.xfiles.di.viewModelModule
import org.koin.android.ext.android.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(dataModule, viewModelModule))
    }


}