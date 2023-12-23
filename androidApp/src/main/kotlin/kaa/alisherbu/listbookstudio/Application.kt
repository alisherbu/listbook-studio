package kaa.alisherbu.listbookstudio

import android.app.Application
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(applicationContext)
    }
}