package com.example.yogadaily.ui.screens

import androidx.lifecycle.ViewModel
import com.example.yogadaily.data.asanas
import com.example.yogadaily.data.model.Asana

class AsanaViewModel : ViewModel() {

    private val asanaList = asanas

    fun getAsanas(): List<Asana> = asanaList

    fun getAsanaById(id: Int): Asana? {
        return asanaList.find { it.id == id }
    }
}