package com.example.ejemplorv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding

class ContactosAdapter(private val contactos: List<Contacto>,
                        private val contactoPulsadoListener:ContactoPulsadoListener)
    :RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contacto: Contacto) {
         
            binding.nombre.text=contacto.nombre

            binding.telefono.text= contacto.telefono
            R.drawable.user
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int /*=contactos.size*/ {


        return contactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])

         holder.itemView.setOnClickListener(){
          contactoPulsadoListener.contactoPulsado(contactos[position])
        }
    }

}
