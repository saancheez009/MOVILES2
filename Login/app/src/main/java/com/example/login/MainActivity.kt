package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.BienvenidaBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val MainBinding = ActivityMainBinding.inflate(layoutInflater)
        val bienvenidaBinding = BienvenidaBinding.inflate(layoutInflater)

        setContentView(MainBinding.root)

        val botonAcceder = MainBinding.accederBoton

        val usuario = MainBinding.usuario

        val contraseña = MainBinding.contra


        //cuando clicke boton acceder
        botonAcceder.setOnClickListener(View.OnClickListener {
            if(usuario.text.toString() == "britany" && contraseña.text.toString() == "ciruela"){
                setContentView(bienvenidaBinding.root)


            }else{
                Toast.makeText(this,"Contraseña o usuario incorrecto", Toast.LENGTH_SHORT).show()
            }
        })

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