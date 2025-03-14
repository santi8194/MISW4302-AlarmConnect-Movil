package com.example.alarmconnect.ui.circulo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alarmconnect.ContactoConfianza

class CirculoViewModel : ViewModel() {

    private val _contactos = MutableLiveData<List<ContactoConfianza>>().apply {
        value = listOf(
            ContactoConfianza("Felipe Gomez", "Hermano"),
            ContactoConfianza("Ana Martinez", "Amiga"),
            ContactoConfianza("Carlos Perez", "Compañero")
        )
    }

    val contactos: LiveData<List<ContactoConfianza>> = _contactos

}
