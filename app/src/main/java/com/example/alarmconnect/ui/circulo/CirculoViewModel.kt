package com.example.alarmconnect.ui.circulo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CirculoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Pantalla 'Círculo de Confianza' en construcción"
    }
    val text: LiveData<String> = _text
}