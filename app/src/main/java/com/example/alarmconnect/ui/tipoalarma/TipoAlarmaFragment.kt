package com.example.alarmconnect.ui.tipoalarma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alarmconnect.R
import com.example.alarmconnect.databinding.FragmentTipoAlarmaBinding
import com.example.alarmconnect.ui.createalarm.CreateAlarmViewModel

class TipoAlarmaFragment : Fragment() {

    private var _binding: FragmentTipoAlarmaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val createAlarmViewModel =
            ViewModelProvider(this).get(CreateAlarmViewModel::class.java)

        _binding = FragmentTipoAlarmaBinding.inflate(inflater, container, false)

        binding.cancelarButton.setOnClickListener {
            findNavController().navigateUp()
        }

        var tipoAlarma = ""
        // Para quien es la alarma?
        binding.paraMiCard.setOnClickListener {
            tipoAlarma = "paraMi"
            val bundle = bundleOf("tipoAlarma" to tipoAlarma)
            findNavController().navigate(R.id.action_navigation_tipo_alarma_to_create_alarm_fragment,bundle)
        }
        binding.otraPersonaCard.setOnClickListener {
            tipoAlarma = "otraPersona"
            val bundle = bundleOf("tipoAlarma" to tipoAlarma)
            findNavController().navigate(R.id.action_navigation_tipo_alarma_to_create_alarm_fragment,bundle)
        }
        return binding.root
    }
}