package com.example.alarmconnect.ui.grabar

import android.media.MediaPlayer
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.alarmconnect.R
import com.example.alarmconnect.databinding.FragmentCreateAlarmBinding
import com.example.alarmconnect.databinding.FragmentGrabarBinding
import com.masoudss.lib.WaveformSeekBar
import java.io.ByteArrayOutputStream
import java.io.IOException
import kotlin.concurrent.read
import kotlin.text.toFloat

class GrabarFragment : Fragment() {

    private var _binding: FragmentGrabarBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var waveformSeekBar: WaveformSeekBar
    private var isPlaying = false
    private var duration: Int? = null
    private var audioCargado = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGrabarBinding.inflate(inflater, container, false)

        waveformSeekBar = binding.waveformSeekbar

        waveformSeekBar.setSampleFrom(R.raw.audio_sample)
        waveformSeekBar.visibility = View.INVISIBLE

        val playButton = binding.playButton
        val grabarButton = binding.grabarButton
        val limpiarButton = binding.limpiarButton
        playButton.isEnabled = false
        limpiarButton.isEnabled = false

        playButton.setOnClickListener {
            if (!isPlaying) {
                startPlaying()
            } else {
                stopPlaying()
            }
        }
        grabarButton.setOnClickListener {
            audioCargado = true
            playButton.isEnabled = true
            limpiarButton.isEnabled = true
            waveformSeekBar.visibility = View.VISIBLE
        }
        limpiarButton.setOnClickListener {
            audioCargado = false
            playButton.isEnabled = false
            limpiarButton.isEnabled = false
            waveformSeekBar.visibility = View.INVISIBLE
        }
        binding.guardarButton.setOnClickListener {
            if (audioCargado) {

                findNavController().popBackStack()
            } else {
                Toast.makeText(activity, "Debes grabar un audio", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun startPlaying() {
        if (mediaPlayer == null) {
            try {
                val audioResourceId = R.raw.audio_sample // Replace with your audio file name
                mediaPlayer = MediaPlayer.create(requireContext(), audioResourceId).apply {
                    start()
                }
                duration = mediaPlayer?.duration
                Log.d("WaveformSeekBar", "duration: $duration")
                isPlaying = true
                binding.playButton.setIconResource(R.drawable.rectangle)
                updateProgress()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            mediaPlayer?.start()
            isPlaying = true
            binding.playButton.setIconResource(R.drawable.rectangle)
            updateProgress()
        }
    }

    private fun stopPlaying() {
        mediaPlayer?.pause()
        isPlaying = false
        binding.playButton.setIconResource(R.drawable.ic_play)
    }

    private fun updateProgress() {
        if (isPlaying) {
            val currentPosition = mediaPlayer?.currentPosition?.toFloat() ?: 0f
            if (duration != null && currentPosition.toInt() >= duration!!) {
                stopPlaying()
            }
            val newProgress = ((currentPosition / (duration ?: 1)) * 100)
            waveformSeekBar.progress = newProgress
            Log.d("WaveformSeekBar", "Progress: $currentPosition")
            handler.postDelayed({ updateProgress() }, 50) // Update every 100ms
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        mediaPlayer = null
        _binding = null
    }
}