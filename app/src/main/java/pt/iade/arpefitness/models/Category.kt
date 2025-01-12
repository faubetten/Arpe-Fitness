package pt.iade.arpefitness.models

import java.io.Serializable

data class Category(
    val id: Int,
    val name: String,
    val exercises: List<Exercise>
): Serializable
