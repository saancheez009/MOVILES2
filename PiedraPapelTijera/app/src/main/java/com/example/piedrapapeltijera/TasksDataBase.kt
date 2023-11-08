package com.example.piedrapapeltijera

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.piedrapapeltijera.Entidades.TaskEntity


@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TasksDataBase : RoomDatabase() {

    abstract fun itemDao(): TaskDao

    companion object {
        @Volatile
        private var Instance: TasksDataBase? = null

        fun getDatabase(context: Context): TasksDataBase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TasksDataBase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}