package com.example.alarmconnect.ui.createalarm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateAlarmViewModel : ViewModel() {
    private val _selectedPriority = MutableLiveData<String>()
    val selectedPriority: LiveData<String> = _selectedPriority
}