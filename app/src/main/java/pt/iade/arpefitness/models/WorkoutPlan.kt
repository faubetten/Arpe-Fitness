package pt.iade.arpefitness.models


import java.io.Serializable

class WorkoutPlan (
    val id: String,
    val userId: String,
    val exercises: List<ExercisePlan>

) : Serializable