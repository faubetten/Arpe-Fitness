package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import pt.iade.arpefitness.models.ExercisePlan
import pt.iade.arpefitness.ui.theme.ArpefitnessTheme

class WorkoutPlan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userObjective = "Hypertrophy"

        val workoutPlan = generateWorkoutPlan(userObjective)
        setContent {
            WorkoutSelectionScreen(workoutPlan)


        }
    }
}



fun generateWorkoutPlan(objective: String): Map<String, List<ExercisePlan>> {
    val workoutA: List<ExercisePlan>
    val workoutB: List<ExercisePlan>

    when (objective) {
        "Hypertrophy" -> {
            workoutA = listOf(
                ExercisePlan("Bench Press", sets = 4, reps = 8..12, restTimePlan = 90),
                ExercisePlan("Dumbbell Fly", sets = 3, reps = 10..12, restTimePlan = 60),
                ExercisePlan("Overhead Press", sets = 4, reps = 8..12, restTimePlan = 90)
            )
            workoutB = listOf(
                ExercisePlan("Squat", sets = 4, reps = 8..12, restTimePlan = 90),
                ExercisePlan("Leg Press", sets = 3, reps = 10..12, restTimePlan = 90),
                ExercisePlan("Crunch", sets = 3, reps = 15..20, restTimePlan = 30)
            )
        }
        "Muscle Definition" -> {
            workoutA = listOf(
                ExercisePlan("Pulldown", sets = 4, reps = 12..15,restTimePlan = 90),
                ExercisePlan("Face Pull", sets = 3, reps = 12..15, restTimePlan = 60),
                ExercisePlan("Barbell Curl", sets = 3, reps = 12..15, restTimePlan = 60)
            )
            workoutB = listOf(
                ExercisePlan("Deadlift", sets = 4, reps = 12..15, restTimePlan = 90),
                ExercisePlan("Leg Raises", sets = 4, reps = 15..20, restTimePlan = 30),
                ExercisePlan("Hamstrings Curl", sets = 3, reps = 12..15, restTimePlan = 60)
            )
        }
        else -> {
            workoutA = listOf(
                ExercisePlan("push Ups", sets = 3, reps = 15..20, restTimePlan = 30),
                ExercisePlan("Pull Ups", sets = 3, reps = 12..15, restTimePlan = 60),
                ExercisePlan("Squats", sets = 4, reps = 10..12, restTimePlan = 90)
            )
            workoutB = listOf(
                ExercisePlan("Deadlift", sets = 3, reps = 12..15, restTimePlan = 90),
                ExercisePlan("Dumbbell Curl", sets = 3, reps = 12..12, restTimePlan = 60),
                ExercisePlan("Crunch", sets = 3, reps = 15..20, restTimePlan = 30)
            )
        }
    }

    return mapOf("Workout A" to workoutA, "Workout B" to workoutB)
}

@Composable
fun WorkoutSelectionScreen(workoutPlan: Map<String, List<ExercisePlan>>) {
    var selectedWorkout by remember { mutableStateOf<String?>(null) }

    if (selectedWorkout == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Select Your Workout Plan",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = { selectedWorkout = "Workout A" }) {
                Text(text = "Workout A")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { selectedWorkout = "Workout B" }) {
                Text(text = "Workout B")
            }
        }
    } else {
        WorkoutSessionPlan(
            sessionName = selectedWorkout!!,
            exercises = workoutPlan[selectedWorkout!!]!!
        )
    }
}

@Composable
fun WorkoutSessionPlan(
    sessionName: String,
    exercises: List<ExercisePlan>
) {
    var currentExerciseIndex by remember { mutableStateOf(0) }
    var showRestTimer by remember { mutableStateOf(false) }
    val currentExercise = exercises[currentExerciseIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
            .padding(16.dp)
    ) {
        if (showRestTimer) {
            RestTimerPlan(
                restTime = currentExercise.restTimePlan,
                onRestFinish = {
                    showRestTimer = false
                    if (currentExerciseIndex < exercises.size - 1) {
                        currentExerciseIndex++
                    }
                }
            )
        } else {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = sessionName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = currentExercise.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column {
                    repeat(currentExercise.sets) { setIndex ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Set ${setIndex + 1}: Reps ${currentExercise.reps}",
                                fontSize = 16.sp
                            )
                            Text(
                                text = "Rest: ${currentExercise.restTimePlan}s",
                                fontSize = 16.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_camera),
                    contentDescription = "Exercise Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { if (currentExerciseIndex > 0) currentExerciseIndex-- },
                        enabled = currentExerciseIndex > 0,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                    ) {
                        Text(text = "< Previous")
                    }

                    val context = LocalContext.current

                    Button(
                        onClick = {
                            // Navegar para a tela TrainingCompleted
                            val intent = Intent(context, TrainingCompleted::class.java)
                            intent.putExtra("caloriesBurned", 150.0)
                            intent.putExtra("trainingTime", 30)
                            context.startActivity(intent)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                    ) {
                        Text(text = "Finish", color = Color.White)
                    }

                    Button(
                        onClick = {
                            if (currentExerciseIndex < exercises.size - 1) {
                                showRestTimer = true
                            }
                        },
                        enabled = currentExerciseIndex < exercises.size - 1,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                    ) {
                        Text(text = "Next >")
                    }
                }

            }
        }
    }
}

@Composable
fun RestTimerPlan(
    restTime: Int,
    onRestFinish: () -> Unit
) {
    var timeLeft by remember { mutableStateOf(restTime) }
    var isRunning by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = timeLeft, key2 = isRunning) {
        if (isRunning && timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
        if (timeLeft == 0 && isRunning) {
            onRestFinish()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEEEEE))
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Time left: $timeLeft s",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    onClick = { isRunning = true },
                    enabled = !isRunning,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text(text = "Start")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { timeLeft = 0; onRestFinish() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.LightGray
                    )
                ) {
                    Text(text = "Skip")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { isRunning = false },
                    enabled = isRunning,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(text = "Stop")
                }


            }
        }
    }
}
