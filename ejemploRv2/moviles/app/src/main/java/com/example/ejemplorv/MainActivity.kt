package com.example.ejemplorv

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ContactosBinding



class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)


        contactos.vistaContactos.adapter=ContactosAdapter(listOf(
        Contacto("Juan","648362245"),
        Contacto("Jorge","648362245"),
        Contacto("Sheila","648362245"),
        Contacto("Juana","648365465"),
        Contacto("Carla","648362245"),
        Contacto("Marta","644892245"),
        Contacto("Paco","648362456"),
        Contacto("Fabián","636962245"),
        Contacto("Jonathan","123362245"/*"htttps"+(100+Math.random().toInt())*/),
        Contacto("Erick","612362245"),
        Contacto("Sandra","648362789"),
        Contacto("Leo","6483625436"),
        Contacto("Messi","648365642")
        )
            ,
            object : ContactoPulsadoListener{
                override fun contactoPulsado(contacto: Contacto) {
                    val dial= Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+contacto.telefono))
                    startActivity(dial)

                   // val view =Intent(Intent.ACTION_VIEW, Uri.parse("name:"+contacto.nombre.get(0)) )
              // startActivity(view)
                }
            }
        )


    }
}