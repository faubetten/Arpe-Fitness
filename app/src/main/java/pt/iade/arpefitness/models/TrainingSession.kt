package pt.iade.arpefitness.models

class TrainingSession(
    val date: Long, // Timestamp
    val caloriesBurned: Float,
    val trainingTime: Long // Em segundos ou milissegundos
)