package pt.iade.arpefitness.models

class ExercisePlan(
    val name: String,
    val sets: Int,
    val reps: IntRange,
    val restTimePlan: Int, // Em segundos
    val imageResId: Int
)
