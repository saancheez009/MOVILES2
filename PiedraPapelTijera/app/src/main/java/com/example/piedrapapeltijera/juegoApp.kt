package com.example.piedrapapeltijera


import android.app.Application
import androidx.room.Room.databaseBuilder

class juegoApp :Application() {
    companion object {
        lateinit var database: TasksDataBase
    }
    override fun onCreate() {
        super.onCreate()
        juegoApp.database =  databaseBuilder(this, TasksDataBase::class.java, "tasks-db").build()
    }
}