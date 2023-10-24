package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.login.R.id.contraseña
import com.example.login.R.id.usuario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val acceder = findViewById<Button>(R.id.acceder)

        val usuario = findViewById<EditText>(R.id.usuario)

        val contraseña = findViewById<EditText>(R.id.contraseña)

         usuario.text
        val text = contraseña.text



    }
}