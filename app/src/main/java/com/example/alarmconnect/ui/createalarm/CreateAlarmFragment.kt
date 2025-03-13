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
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Date

class CreateAlarmFragment : Fragment() {

    private var _binding: FragmentCreateAlarmBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAlarmBinding.inflate(inflater, container, false)
        val tipoAlarma = arguments?.getString("tipoAlarma")

        if (tipoAlarma == "paraMi") {
            binding.contactoConfianzaRow.visibility = View.GONE
        } else {
            binding.contactoConfianzaRow.visibility = View.VISIBLE
        }

        // Nivel de prioridad para alarma
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

        // Selección de fecha y hora
        val calendarConstants = CalendarConstraints.Builder().setStart(Date().time).build()
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Seleccionar fecha para la alarma")
                .setCalendarConstraints(calendarConstants)
                .build()
        val timePicker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(10)
                .setTitleText("Seleccionar hora para la alarma")
                .build()
        datePicker.addOnPositiveButtonClickListener {
            timePicker.show(parentFragmentManager, "tag")
        }
        binding.seleccionarFechaButton.setOnClickListener {
            datePicker.show(parentFragmentManager, "tag")
        }

        // Guardar
        binding.guardarButton.setOnClickListener {

            findNavController().navigateUp()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}