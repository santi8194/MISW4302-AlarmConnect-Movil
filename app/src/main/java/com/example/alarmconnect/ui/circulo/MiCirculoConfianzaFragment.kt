package com.example.alarmconnect.ui.circulo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmconnect.databinding.FragmentCirculoConfianzaBinding
import com.example.alarmconnect.ContactoConfianza
import com.example.alarmconnect.FavoritosListAdapter
import com.example.alarmconnect.MiCirculoListAdapter

class MiCirculoConfianzaFragment : Fragment() {

    private var _binding: FragmentCirculoConfianzaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCirculoConfianzaBinding.inflate(inflater, container, false)
        val view = binding.root

        // Lista de contactos de prueba
        val listaFavoritos = listOf(
            ContactoConfianza("Felipe Gomez", "Hermano"),
            ContactoConfianza("Ana Martinez", "Amiga")
        )

        val listaMiCirculo = listOf(
            ContactoConfianza("Carlos Perez", "Compañero"),
            ContactoConfianza("Clara Delgado", "Mamá"),
            ContactoConfianza("Yuya Gonzalez", "Familia")
        )

        // Configurar RecyclerView de Favoritos
        binding.recyclerFavoritos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFavoritos.adapter = FavoritosListAdapter(listaFavoritos)

        // Configurar RecyclerView de Mi Círculo
        binding.recyclerMiCirculo.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMiCirculo.adapter = MiCirculoListAdapter(listaMiCirculo)

        // Acción del botón Buscar Externos
        binding.buttonBuscarExternos.setOnClickListener {
            //TODO
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
