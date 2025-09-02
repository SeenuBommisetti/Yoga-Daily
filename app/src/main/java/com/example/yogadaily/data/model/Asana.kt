package com.example.yogadaily.data.model

data class Asana(
    val id: Int,
    val day: Int,
    val title: String,
    val image: Int,
    val difficulty: String,
    val benefits: String,
    val steps: List<String>
)


