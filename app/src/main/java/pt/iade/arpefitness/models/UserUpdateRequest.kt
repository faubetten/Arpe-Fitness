package pt.iade.arpefitness.models

data class UserUpdateRequest(
    val userName: String,
    val userEmail: String,
    val userBirthDate: String,
    val userGender: String,
    val userHeight: Double,
    val userWeight: Double,
    val userGoal: String,
    val userExperience: String
)
