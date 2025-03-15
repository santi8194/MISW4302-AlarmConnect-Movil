package com.example.alarmconnect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmconnect.databinding.ListItemFavoritosBinding

class FavoritosListAdapter(
    private val contactos: List<ContactoConfianza>
) : RecyclerView.Adapter<FavoritosListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListItemFavoritosBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contacto: ContactoConfianza) {
            binding.nombreContacto.text = contacto.nombre
            binding.relacionContacto.text = contacto.relacion
            binding.eliminarButton.setOnClickListener {
                // Acción de eliminar (puede quedar vacío por ahora)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemFavoritosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])
    }

    override fun getItemCount(): Int = contactos.size
}
