package com.example.alarmconnect.ui.createalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alarmconnect.R
import com.example.alarmconnect.databinding.FragmentCirculoBinding
import com.example.alarmconnect.databinding.FragmentCreateAlarmBinding
import com.example.alarmconnect.ui.circulo.CirculoViewModel

class CreateAlarmFragment : Fragment() {

    private var _binding: FragmentCreateAlarmBinding? = null
    private val binding get() = _binding!!
    private var tipoAlarma = "paraMi"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val createAlarmViewModel =
            ViewModelProvider(this).get(CreateAlarmViewModel::class.java)

        _binding = FragmentCreateAlarmBinding.inflate(inflater, container, false)

        binding.cancelarButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.paraMiCard.setOnClickListener {
            binding.preguntaParaQuien.visibility = View.GONE
            binding.opcionesParaQuien.visibility = View.GONE
            binding.cancelarButton.visibility = View.GONE
            binding.crearAlarmaTable.visibility = View.VISIBLE
            binding.guardarButton.visibility = View.VISIBLE
            binding.contactoConfianzaRow.visibility = View.GONE
            tipoAlarma = "paraMi"
        }
        binding.otraPersonaCard.setOnClickListener {
            binding.preguntaParaQuien.visibility = View.GONE
            binding.opcionesParaQuien.visibility = View.GONE
            binding.cancelarButton.visibility = View.GONE
            binding.crearAlarmaTable.visibility = View.VISIBLE
            binding.guardarButton.visibility = View.VISIBLE
            binding.contactoConfianzaRow.visibility = View.VISIBLE
            tipoAlarma = "otraPersona"
        }

        val bajaButton = binding.bajaBtn
        val mediaButton = binding.mediaBtn
        val altaButton = binding.altaBtn
        val buttons = listOf(bajaButton, mediaButton, altaButton)

        val onClickListener = View.OnClickListener { clickedButton ->
            buttons.forEach { button ->
                button.setBackgroundColor(resources.getColor(R.color.md_theme_background, null))
                button.setTextColor(resources.getColor(R.color.md_theme_primary, null))
            }
            clickedButton.setBackgroundColor(resources.getColor(R.color.md_theme_primary, null))
            if (clickedButton is Button) {
                clickedButton.setTextColor(resources.getColor(R.color.md_theme_background, null))
            }
        }
        bajaButton.setOnClickListener(onClickListener)
        mediaButton.setOnClickListener(onClickListener)
        altaButton.setOnClickListener(onClickListener)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}