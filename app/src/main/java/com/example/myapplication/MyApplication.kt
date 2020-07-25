package com.example.myapplication

import android.app.Application
import androidx.room.Room

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

    //fun getDB = db

    companion object {
        var application: MyApplication? = null
        var db: AppDatabase? = null
    }
}