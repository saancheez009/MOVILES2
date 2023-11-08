package com.example.piedrapapeltijera.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_entity")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var partidasJugadas:Int=0,
    var maxPuntuacion:Int=0)