package pt.iade.arpefitness

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        setContent {
            SelectedExercisesScreen(navController = rememberNavController()) // Adicionando navController
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedExercisesScreen(navController: NavController) {
    // Usando dados estáticos para visualização em Preview
    val selectedExercises = listOf(
        Exercise("Flexão", "https://media.musclewiki.com/media/uploads/videos/branded/male-Machine-machine-pec-fly-front.mp4#t=0.1"),
        Exercise("Agachamento", "https://media.musclewiki.com/media/uploads/videos/branded/male-Machine-machine-pec-fly-front.mp4#t=0.1"),
        Exercise("Abdominal", "https://media.musclewiki.com/media/uploads/videos/branded/male-Machine-machine-pec-fly-front.mp4#t=0.1")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Workout") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
                text = "Treinos",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(selectedExercises) { exercise ->
                    ExerciseItem(exercise)
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
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            exercise.imageUrl?.let { imageUrl ->
                // Usando Image como exemplo, caso queira imagens reais, troque para AsyncImage
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_camera), // Exemplo de imagem
                    contentDescription = exercise.name,
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
                Text(
                    text = "Click to add sets",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectedExercisesScreen() {
    // Exemplo de dados para a preview
    val navController = rememberNavController()

    SelectedExercisesScreen(navController)
}
