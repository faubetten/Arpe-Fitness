package pt.iade.arpefitness.models

data class Levelcard (
    val title: String,
    val description: String,
    val onClick: ()->Unit
)