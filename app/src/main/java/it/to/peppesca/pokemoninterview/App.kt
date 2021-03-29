package it.to.peppesca.pokemoninterview

import android.app.Application
import it.to.peppesca.pokemoninterview.injection.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * [App] is the Application class of the project
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
        }
    }
}