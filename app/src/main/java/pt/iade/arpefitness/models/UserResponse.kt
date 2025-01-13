package pt.iade.arpefitness.models

import java.time.LocalDate

data class UserResponse(
    val userId: Int,
    val userName: String,
    val userEmail: String,
    val userBirthDate: LocalDate, // Pode ser nulo
    val userGender: String?, // Pode ser nulo
    val userHeight: Double?,
    val userWeight: Double?,
    val userGoal: String?,
    val userExperience: String?
)