package com.example.alarmconnect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmconnect.databinding.ListItemCirculoBinding

class CirculoListAdapter(
    private val contactos: List<ContactoConfianza>,
    private val onClick: (ContactoConfianza) -> Unit
) : RecyclerView.Adapter<CirculoListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListItemCirculoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contacto: ContactoConfianza, onClick: (ContactoConfianza) -> Unit) {
            binding.nombreContacto.text = contacto.nombre
            binding.relacionContacto.text = contacto.relacion
            binding.seleccionarButton.setOnClickListener { onClick(contacto) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemCirculoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position], onClick)
    }

    override fun getItemCount(): Int = contactos.size
}


data class ContactoConfianza(val nombre: String, val relacion: String)