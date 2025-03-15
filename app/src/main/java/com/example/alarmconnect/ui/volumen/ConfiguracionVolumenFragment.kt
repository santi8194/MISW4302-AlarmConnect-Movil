package com.example.alarmconnect.ui.volumen

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmconnect.R
import com.example.alarmconnect.databinding.FragmentConfiguracionVolumenVibrarBinding
import com.google.android.material.slider.Slider

class ConfiguracionVolumenFragment : Fragment() {

    private var _binding: FragmentConfiguracionVolumenVibrarBinding? = null
    private val binding get() = _binding!!
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false
    private var volumenActual = 0.5f // Valor inicial del volumen

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfiguracionVolumenVibrarBinding.inflate(inflater, container, false)


        // Configurar el slider de volumen
        binding.sliderVolume.addOnChangeListener { _, value, _ ->
            volumenActual = value / 100f // Convertir el valor del slider a un rango de 0.0 - 1.0
            binding.textVolumeLevel.text = value.toInt().toString()
        }

        // Configurar el botón de reproducir
        binding.playButton.setOnClickListener {
            if (!isPlaying) {
                startPlaying()
            } else {
                stopPlaying()
            }
        }

        // Configurar el botón de guardar para volver a Crear Alarma
        binding.buttonGuardar.setOnClickListener {
            findNavController().navigate(R.id.action_configuracionVolumenFragment_to_create_alarm_fragment)
        }

        return binding.root
    }

    private fun startPlaying() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audio_sample).apply {
                setVolume(volumenActual, volumenActual) // Aplicar volumen actual
                start()

                // Listener que detecta cuando el audio termina
                setOnCompletionListener {
                    stopPlaying()
                }
            }
        } else {
            mediaPlayer?.setVolume(volumenActual, volumenActual) // Aplicar volumen antes de reproducir
            mediaPlayer?.start()
        }

        isPlaying = true
        binding.playButton.setIconResource(R.drawable.rectangle) // Cambia el icono a "Stop"
    }

    private fun stopPlaying() {
        mediaPlayer?.pause()
        mediaPlayer?.seekTo(0) // Reiniciar el audio al principio
        isPlaying = false
        binding.playButton.setIconResource(R.drawable.ic_play) // Cambia el icono a "Play"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        mediaPlayer = null
        _binding = null
    }
}
