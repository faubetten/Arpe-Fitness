package com.example.arpefitness.models

import androidx.compose.ui.graphics.painter.Painter
import java.io.Serializable

class Exercise (
    val id: Int,
    val name: String,
    val description: String,
    val duration: Int,
    val calories: Int,
    val image: Painter? // The ? means that the image can be null
): Serializable {
    fun isCompleted(): Boolean {
        return false
    }


}