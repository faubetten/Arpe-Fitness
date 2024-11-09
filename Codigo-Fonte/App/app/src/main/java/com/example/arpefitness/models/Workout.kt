package com.example.arpefitness.models

import androidx.compose.ui.graphics.painter.Painter
import java.io.Serializable


//Need the complete Database
data class Workout (
    val id: Int,
    val name: String,
    val description: String,
    val duration: Int,
    val calories: Int,
    val image: Painter,
    val exercises: List<Exercise>
): Serializable {
    fun isCompleted(): Boolean {
        return false
    }
}



