package pt.iade.arpefitness.models

import java.io.Serializable

data class Exercise (
    val id: Int,
    val name: String,
    val description: String,
    val photoPath: String
): Serializable