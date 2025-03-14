package com.example.alarmconnect.ui.repeticion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmconnect.R
import com.example.alarmconnect.databinding.FragmentConfiguracionRepeticionBinding

class ConfiguracionRepeticionFragment : Fragment() {

    private var _binding: FragmentConfiguracionRepeticionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfiguracionRepeticionBinding.inflate(inflater, container, false)
        val view = binding.root

        // Lista de opciones para el ExposedDropdownMenu
        val opcionesFrecuencia = listOf(
            "Diaria",
            "Días Hábiles [Lunes a Viernes]",
            "Fines de Semana [Sábado y Domingo]",
            "Semanal",
            "Mensual"
        )

        // Configurar el adapter para el dropdown
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, opcionesFrecuencia)
        binding.dropdownFrecuencia.setAdapter(adapter)

        // Seleccionar por defecto "Diaria"
        binding.dropdownFrecuencia.setText(opcionesFrecuencia[0], false)

        // Manejar cambios en la selección del dropdown
        binding.dropdownFrecuencia.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            if (opcionesFrecuencia[position] == "Diaria") {
                binding.linearLayoutCadaXDias.visibility = View.VISIBLE
            } else {
                binding.linearLayoutCadaXDias.visibility = View.GONE
            }
        }

        // Botón Guardar: Navega de regreso a la pantalla de crear alarma
        binding.buttonGuardarRepeticion.setOnClickListener {
            findNavController().navigate(R.id.action_configuracionRepeticionFragment_to_create_alarm_fragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
