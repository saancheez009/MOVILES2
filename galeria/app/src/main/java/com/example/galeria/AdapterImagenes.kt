package com.example.galeria

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.galeria.databinding.VistaFotosBinding

class AdapterImagenes : RecyclerView.Adapter<AdapterImagenes.MyViewHolder>() {
    var itemList: MutableList<Imagen> = ArrayList()
    var context : Context?=null

    class MyViewHolder(val binding:VistaFotosBinding):RecyclerView.ViewHolder(binding.root)

    fun AdapterImagenes (Foto:MutableList<Imagen>, context : Context){
        this.itemList = Foto
        this.context = context
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList?.get(position)

        Glide.with(context!!.applicationContext)
            .load(item?.imagenUrl)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.binding.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterImagenes.MyViewHolder {
        return AdapterImagenes.MyViewHolder(VistaFotosBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return itemList!!.size
    }
}