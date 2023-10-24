package com.example.galeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.galeria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val COLUMNAS = 3
    val imagenList = ArrayList<Imagen>()
    val galeriaAdapter : AdapterImagenes = AdapterImagenes()

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargar_imagenes()

    }

    fun cargar_imagenes(){
    galeriaAdapter.AdapterImagenes(imagenList,this)
        binding.recyclerView.layoutManager = GridLayoutManager(this,COLUMNAS)
        binding.recyclerView.adapter =galeriaAdapter
        galeriaAdapter.notifyDataSetChanged()

        imagenList.add(Imagen("https://loremflickr.com/320/240/paris,girl/all","Imagen1"))
        imagenList.add(Imagen("https://loremflickr.com/320/240/paris,girl/all","Imagen2"))
        imagenList.add(Imagen("https://s1.eestatic.com/2022/09/05/alicante/vivir/700940494_226892474_1706x960.jpg","Imagen3"))
        imagenList.add(Imagen("https://s1.eestatic.com/2022/09/05/alicante/vivir/700940494_226892474_1706x960.jpg","Imagen4"))
        imagenList.add(Imagen("https://s1.eestatic.com/2022/09/05/alicante/vivir/700940494_226892474_1706x960.jpg","Imagen5"))
        imagenList.add(Imagen("https://s1.eestatic.com/2022/09/05/alicante/vivir/700940494_226892474_1706x960.jpg","Imagen6"))
        galeriaAdapter.notifyDataSetChanged()
    }
}