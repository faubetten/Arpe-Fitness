package pt.iade.arpefitness

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController


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

    val selectedExercises = remember { mutableStateMapOf<String, MutableSet<String>>() }

    val categories = listOf(
        "Chest" to listOf("Bench press", "Dumbbell Fly", "Seated crucifix", "Push-up"),
        "Triceps" to listOf("Triceps Pushdown", "Overhead Triceps Extension", "Close-Grip Bench Press", "Lever Triceps Dips"),
        "Back" to listOf("Pulldown", "Pull-Ups", "Face pull", "Deadlift"),
        "Biceps" to listOf("Barbell Curl", "Dumbbell Hammer Curl", "Concentration Curl", "Preacher Curl"),
        "Shoulders" to listOf("Overhead Press", "Lateral Raises", "Front Raises", "Arnold Press"),
        "Abs" to listOf("Crunches", "Plank", "Bicycle Crunch", "Leg Raises"),
        "Leg" to listOf("Squat", "Leg Press", "Hamstrings", "Leg Curl"),
        "Run" to listOf("Cardio")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD3D3D3))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        categories.forEach { (category, exercises) ->
            item {
                ExerciseCategory(
                    categoryName = category,
                    exercises = exercises,
                    selectedExercises = selectedExercises
                )
            }
        }
        item {
            Button(
                onClick = {

                    // Filtrar exercícios selecionados
                    /* val selectedExercises = mutableMapOf<String, List<Exercise>>()
                     selectedExercisesMap.forEach { (category, exercises) ->
                         if (exercises.isNotEmpty()) {
                             selectedExercises[category] = exercises.map { Exercise(it, getImageForExercise(it)) }
                         }
                     }

                     navController.navigate("selected_exercises") {
                         SelectedExercisesScreen(selectedExercises)
                     }
                */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF999999),
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
    exercises: List<String>,
    selectedExercises: MutableMap<String, MutableSet<String>>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF999999))
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
                        if (checked) selectedSet.add(exercise) else selectedSet.remove(exercise)
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.LightGray, // Cor da caixa quando marcada
                        uncheckedColor = Color.LightGray, // Cor da caixa quando desmarcada
                        checkmarkColor = Color.DarkGray // Cor do checkmark (✓)
                    )
                )
                Text(
                    text = exercise,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
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
