data class TrainingSession(
    val date: Long, //
    val caloriesBurned: Float,
    val trainingTime: Long
) {
    fun getFormattedTime(): String {
        val minutes = trainingTime / 60
        val seconds = trainingTime % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}
