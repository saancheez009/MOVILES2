package com.example.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.BienvenidaBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val MainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(MainBinding.root)


        val acceder = MainBinding.acceder

        val usuario = MainBinding.usuario

        val contrase = MainBinding.contra

        //cuando clicke boton acceder
        acceder.setOnClickListener {

            if (usuario.text.toString() != "") {
                //Accedemos a los elementos bienvenida
                val bienvenidaBinding = BienvenidaBinding.inflate(layoutInflater)
                setContentView(bienvenidaBinding.root)

                //Mostramos mensaje
                bienvenidaBinding.saludo.text = "Nos alegramos de que vuelvas, $usuario"

            } else {
                val toast = Toast.makeText(
                    applicationContext,
                    "Debe introducir un nombre de usuario",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }

    //pausa de pag
    override fun onPause() {
        super.onPause()

        //Accedemos a bienvenida
        val bienvenidaBinding = BienvenidaBinding.inflate(layoutInflater)

        setContentView(bienvenidaBinding.root)

    }

    // reanuda aplicacion
    override fun onResume() {
        super.onResume()


        var MainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(MainBinding.root)




        var usuario = MainBinding.usuario.text

        //Mostramos la bienvenida otra vez
        val toast = Toast.makeText(
            applicationContext,
            "Bienvenido de nuevo $usuario",
            Toast.LENGTH_SHORT
        ).show()

    }

    //Cierre
    override fun onDestroy() {
        super.onDestroy()

        val MainBinding = ActivityMainBinding.inflate(layoutInflater)
        var usuario = MainBinding.usuario.text

        val toast = Toast.makeText(
            applicationContext,
            "Se ha cerrado la sesion de $usuario",
            Toast.LENGTH_SHORT
        ).show()

    }




}