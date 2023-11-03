package com.example.roomprueba

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomprueba.entidades.TaskEntity

@Dao
interface TaskDao {
    @Query("SELECT * FROM task_entity")
    fun selectAllTasks(): MutableList<TaskEntity>

    @Query("SELECT * FROM task_entity WHERE id = :id")
    fun findById(id: Int): TaskEntity


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tasks: List<TaskEntity>)

   // @Update

   // @Delete

}