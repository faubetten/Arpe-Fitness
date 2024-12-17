package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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

data class Exercise(val name: String, val imageUrl: String?)

class Selected_exercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Recebendo a lista de exercícios com Intent
        val selectedExercisesList = intent.getStringArrayListExtra("selected_exercises") ?: arrayListOf()

        // Convertendo os nomes em objetos do tipo Exercise
        val selectedExercises = selectedExercisesList.map { exerciseName ->
            Exercise(name = exerciseName, imageUrl = null) // Substituir o "null" por URLs se necessário
        }

        setContent {
            SelectedExercisesScreen(
                navController = rememberNavController(),
                selectedExercises = selectedExercises // Passando a lista corretamente
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedExercisesScreen(navController: NavController, selectedExercises: List<Exercise>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Workout") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("select_exercise") }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF999999),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Training",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier =Modifier.height(10.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                Button(onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray,
                    contentColor = Color.White),
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp).size(40.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                    Text(
                        text = "start training",
                        fontSize = 18.sp,

                    )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Exercises",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(selectedExercises) { exercise ->
                    ExerciseItem(exercise, navController)
                }
            }
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Substituindo por Coil para carregar imagens
            if (exercise.imageUrl != null) {
                // Usando Coil AsyncImage para carregar a imagem
                androidx.compose.foundation.Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_camera),
                    contentDescription = exercise.name,
                    modifier = Modifier.size(80.dp)
                )
            } else {
                // Placeholder quando a URL da imagem é nula
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_camera), // Exemplo de ícone local
                    contentDescription = "Placeholder Image",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(end = 16.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = exercise.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))

                NavigateToAddSets()

               /* Text(modifier = Modifier.clickable {val context = LocalContext.current,
                                                   val intent = Intent(context, AddSets::class.java)
                    context.startActivity(intent)
                },
                    text = "Click to add sets",
                    fontSize = 14.sp,
                    color = Color.Gray
                )*/
            }
        }
    }
}

@Composable
fun NavigateToAddSets() {
    val context = LocalContext.current // Obtenha o contexto atual
    Text(
        text = "Click to add sets",
        modifier = Modifier.clickable {
            val intent = Intent(context, AddSets::class.java)
            context.startActivity(intent)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectedExercisesScreen() {
    val sampleExercises = listOf(
        Exercise("Push-ups", null),
        Exercise("Squats", null),
        Exercise("Plank", null)
    )
    SelectedExercisesScreen(navController = rememberNavController(), selectedExercises = sampleExercises)
}


