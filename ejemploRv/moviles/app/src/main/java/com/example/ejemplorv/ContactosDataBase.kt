package com.example.ejemplorv

@Database(entities = arrayOf(TaskEntity::class), version = 1)


abstract class ContactosDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
