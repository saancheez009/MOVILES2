package com.example.ejemplorv
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ejemplorv.entidades.ContactosEntity

@Dao
interface ContactosDao {
    @Query("SELECT * FROM contactos_entity")
    suspend fun getAllTasks(): MutableList< ContactosEntity>  // Función que devuelve todas las tareas de la base de datos en una lista Mutable.

    @Insert
    suspend fun addTask(contactosEntity : ContactosEntity):Long    // Función que añade una tarea, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.



    @Update
    suspend fun updateTask(contacto: ContactosEntity):Int         // Función que actualiza una tarea y devuelve

    @Delete
    suspend fun deleteTask(contacto: ContactosEntity):Int         // Función que borra una tarea y devuelve
}

// @Update

// @Delete

