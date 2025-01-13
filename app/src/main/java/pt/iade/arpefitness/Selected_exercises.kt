package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pt.iade.arpefitness.models.Exercise

class Selected_exercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Recebendo a lista de exercícios com Intent
        val selectedExercisesList = intent.getStringArrayListExtra("selected_exercises") ?: arrayListOf()

        // Convertendo os dados recebidos em objetos do tipo Exercise
        val selectedExercises = selectedExercisesList.map { data ->
            val parts = data.split(":")
            parts.getOrNull(1)?.toIntOrNull()?.let {
                Exercise(
                    id = parts[0].toIntOrNull() ?: 0 ,
                    name = parts[0],
                    photoPath = it,
                    description = "",// Converte para Int caso seja ID válido

                )
            }
        }

        setContent {
            SelectedExercisesScreen(
                navController = rememberNavController(),
                selectedExercises = selectedExercises
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedExercisesScreen(navController: NavController, selectedExercises: List<Exercise?>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Workout", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("select_exercise") }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF607D8B),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFFF5F5F5))
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Training",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF607D8B)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                val context = LocalContext.current

                Button(
                    onClick = {
                        val selectedExercisesData = ArrayList(selectedExercises.map { exercise ->
                            "${exercise?.id}:${exercise?.name}:${exercise?.photoPath ?: 0}:${exercise?.description}"
                        })

                        val intent = Intent(context, AddSets::class.java).apply {
                            putStringArrayListExtra("selected_exercises", selectedExercisesData)
                        }
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0XFF607D8B),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "Click to add sets",
                        fontSize = 18.sp
                    )
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Selected Exercises",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF607D8B)
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(selectedExercises) { exercise ->
                    if (exercise != null) {
                        ExerciseItem(exercise)
                    }
                }
            }
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFECEFF1)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            exercise.photoPath?.let { imageResId ->
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = exercise.name,
                    modifier = Modifier.size(80.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = exercise.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF607D8B)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectedExercisesScreen() {
    val sampleExercises = listOf(
        Exercise(1,"Push-ups", description = "", photoPath = R.drawable.push_ups  ),
        Exercise(2,"Squats", description = "", photoPath = R.drawable.squat ),
        Exercise(3,"Plank", description = "", photoPath = R.drawable.plank  )
    )
    SelectedExercisesScreen(navController = rememberNavController(), selectedExercises = sampleExercises)
}
