package com.example.roomprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.roomprueba.entidades.TaskEntity

lateinit var recyclerView: RecyclerView
lateinit var tasks: MutableList<TaskEntity>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tasks = ArrayList()
        getTasks()
    }
}