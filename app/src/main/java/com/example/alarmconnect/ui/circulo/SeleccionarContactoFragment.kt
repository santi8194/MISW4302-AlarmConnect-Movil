package com.example.alarmconnect.ui.circulo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmconnect.CirculoListAdapter
import com.example.alarmconnect.ContactoConfianza
import com.example.alarmconnect.R
import com.example.alarmconnect.databinding.FragmentSeleccionarContactoBinding

class SeleccionarContactoFragment : Fragment() {

    private var _binding: FragmentSeleccionarContactoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CirculoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Log.e("CirculoFragment", "✅ onCreateView() SE ESTÁ EJECUTANDO")
        _binding = FragmentSeleccionarContactoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Lista de contactos estáticos
        val contactos = listOf(
            ContactoConfianza("Felipe Gomez", "Hermano"),
            ContactoConfianza("Ana Martinez", "Amiga"),
            ContactoConfianza("Carlos Perez", "Compañero"),
            ContactoConfianza("Clara Delgado", "Mamá") ,
            ContactoConfianza("Yuya Gonzalez", "Familia")
        )


        // Pasar NavController y función onClick al Adapter
        adapter = CirculoListAdapter(contactos, findNavController()) { contacto ->
            Log.d("CirculoFragment", "Contacto seleccionado: ${contacto.nombre}")
        }

        // Set up RecyclerView
        binding.recyclerCirculo.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCirculo.adapter = adapter


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
