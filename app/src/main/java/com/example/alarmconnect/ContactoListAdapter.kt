package com.example.alarmconnect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmconnect.databinding.ListItemContactoBinding

class CirculoListAdapter(
    private val contactos: List<ContactoConfianza>,
    private val navController: NavController,
    private val onClick: (ContactoConfianza) -> Unit
) : RecyclerView.Adapter<CirculoListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contacto: ContactoConfianza, navController: NavController, onClick: (ContactoConfianza) -> Unit) {
            binding.nombreContacto.text = contacto.nombre
            binding.relacionContacto.text = contacto.relacion
            //binding.seleccionarButton.setOnClickListener { onClick(contacto) }
            //Configurar clic en el botón "Seleccionar"
            binding.seleccionarButton.setOnClickListener {
                navController.navigate(R.id.action_seleccionarContactoFragment_to_crearAlarmaFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position], navController, onClick)
    }

    override fun getItemCount(): Int = contactos.size
}


data class ContactoConfianza(val nombre: String, val relacion: String)