package pt.iade.arpefitness.ui.exercise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import pt.iade.arpefitness.R
import pt.iade.arpefitness.Selected_exercises
import pt.iade.arpefitness.models.Category
import pt.iade.arpefitness.models.Exercise

class SelectExercise : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercisesScreen()
        }
    }
}

@Composable
fun ExercisesScreen() {
    val context = LocalContext.current


    val categories = listOf(
        Category(
            id = 1,
            name = "Chest",
            exercises = listOf(
                Exercise(
                    name = "Bench press",
                    photoPath = R.drawable.bench_press,
                    id = 1,
                    description = ""
                ),
                Exercise(name = "Dumbbell Fly", photoPath = R.drawable.dumbbell, id = 2, description = ""),
                Exercise(name = "Cable Crossover", photoPath = R.drawable.cable, id = 3, description = ""),
                Exercise(name = "Push-ups", photoPath = R.drawable.push_ups, id = 4, description = "")
            )
        ),
        Category(
            id = 2,
            name = "Triceps",
            exercises = listOf(
                Exercise(name = "Triceps Pushdown", photoPath = R.drawable.triceps_pushdown, id = 5 , description = ""),
                Exercise(name = "Overhead Triceps Extension", photoPath = R.drawable.overhead_triceps_extension, id = 6, description = ""),
                Exercise(name = "Close-Grip Bench Press", photoPath = R.drawable.close_grip, id = 7, description = ""),
                Exercise(name = "Lever Triceps Dips", photoPath = R.drawable.lever_triceps_dips, id = 8, description = "")
            )
        ),
        Category(
            id = 3,
            name = "Back",
            exercises = listOf(
                Exercise(name = "Pulldown", photoPath = R.drawable.pulldown, id = 9, description = ""),
                Exercise(name = "Pull-Ups", photoPath = R.drawable.pull_ups, id = 10, description = ""),
                Exercise(name = "Face pull", photoPath = R.drawable.facepull, id = 11, description = ""),
                Exercise(name = "Deadlift", photoPath = R.drawable.deadlift, id = 12, description = "")
            )
        ),
        Category(
            id = 4,
            name = "Biceps",
            exercises = listOf(
                Exercise(name = "Barbell Curl", photoPath = R.drawable.barbell_curl, id = 13 , description = ""),
                Exercise(name = "Dumbbell Hammer Curl", photoPath = R.drawable.dumbbell, id = 14, description = ""),
                Exercise(name = "Concentration Curl", photoPath = R.drawable.concentration_curl, id = 15 , description = ""),
                Exercise(name = "Preacher Curl", photoPath = R.drawable.preacher_curl, id = 16 , description = "")
            )
        ),
        Category(
            id = 5,
            name = "Shoulders",
            exercises = listOf(
                Exercise(name = "Overhead Press", photoPath = R.drawable.overhead_press, id = 17 , description = ""),
                Exercise(name = "Lateral Raises", photoPath = R.drawable.lateral_raises, id = 18 , description = ""),
                Exercise(name = "Front Raises", photoPath = R.drawable.front_raises, id = 19, description = ""),
                Exercise(name = "Arnold Press", photoPath = R.drawable.arnold_press, id = 20, description = "")
            )
        ),
        Category(
            id = 6,
            name = "Abs",
            exercises = listOf(
                Exercise(name = "Crunches", photoPath = R.drawable.crunch, id = 21 , description = ""),
                Exercise(name = "Plank", photoPath = R.drawable.plank, id = 22 , description = ""),
                Exercise(name = "Bicycle Crunch", photoPath = R.drawable.bicycle_crunch, id = 23 , description = ""),
                Exercise(name = "Leg Raises", photoPath = R.drawable.leg_raises, id = 24, description = "")
            )
        ),
        Category(
            id = 7,
            name = "Leg",
            exercises = listOf(
                Exercise(name = "Squat", photoPath = R.drawable.squat, id = 25 , description = ""),
                Exercise(name = "Leg Press", photoPath = R.drawable.leg_press, id = 27 , description = ""),
                Exercise(name = "Hamstrings", photoPath = R.drawable.hamstrings, id = 28, description = ""),
                Exercise(name = "Leg Curl", photoPath = R.drawable.leg_curl, id = 29, description = "")
            )
        ),
        Category(
            id = 8,
            name = "Run",
            exercises = listOf(
                Exercise(name = "Cardio", photoPath = R.drawable.cardio, id =30 , description = "")
            )
        )
    )


    val selectedExercises = remember { mutableStateMapOf<String, MutableSet<String>>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Exibir categorias carregadas
        categories.forEach { category ->
            item {
                ExerciseCategory(
                    categoryName = category.name,
                    exercises = category.exercises,
                    selectedExercises = selectedExercises
                )
            }
        }
        item {
            Button(
                onClick = {
                    val selectedExercisesList = categories.flatMap { category ->
                        category.exercises.filter { exercise ->
                            selectedExercises[category.name]?.contains(exercise.name) == true
                        }.map { exercise ->
                            "${exercise.name}:${exercise.photoPath}" // Inclua nome e ID de imagem
                        }
                    }

                    val intent = Intent(context, Selected_exercises::class.java).apply {
                        putStringArrayListExtra("selected_exercises", ArrayList(selectedExercisesList))
                    }

                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF607D8B),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Apply", fontSize = 18.sp)
            }

        }
    }
}

@Composable
fun ExerciseCategory(
    categoryName: String,
    exercises: List<Exercise>,
    selectedExercises: MutableMap<String, MutableSet<String>>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0XFF607D8B))
            .padding(8.dp)
    ) {
        // Header com nome da categoria
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = categoryName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
        }

        exercises.forEach { exercise ->
            val isChecked = remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { checked ->
                        isChecked.value = checked
                        val selectedSet = selectedExercises.getOrPut(categoryName) { mutableSetOf() }
                        if (checked) selectedSet.add(exercise.name) else selectedSet.remove(exercise.name)
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.LightGray,
                        uncheckedColor = Color.LightGray,
                        checkmarkColor = Color.DarkGray
                    )
                )
                Text(
                    text = exercise.name,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                // Exibir imagem (GIF ou drawable)
                AsyncImage(
                    model = exercise.photoPath,
                    contentDescription = exercise.name,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseScreenPreview() {
    ExercisesScreen()
}