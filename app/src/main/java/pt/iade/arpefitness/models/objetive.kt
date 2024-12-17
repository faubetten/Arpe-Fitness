package pt.iade.arpefitness.models

data class objetive(
    val title: String,
    val description: String,
    val onClick: () -> Unit
)