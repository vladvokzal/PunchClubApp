package ru.nsu.lightweight.punchclub

import android.app.Application

class ProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        applicationInstance = this
    }

    companion object {
        lateinit var applicationInstance: ProjectApplication
    }
}