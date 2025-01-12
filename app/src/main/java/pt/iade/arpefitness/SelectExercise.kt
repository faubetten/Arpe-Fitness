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
import pt.iade.arpefitness.Selected_exercises
import pt.iade.arpefitness.models.Category
import pt.iade.arpefitness.models.Exercise
import pt.iade.arpefitness.network.ApiService
import pt.iade.arpefitness.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
    val categories = remember { mutableStateOf<List<Category>>(emptyList()) }

    // Carregar categorias da API
    LaunchedEffect(true) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if (response.isSuccessful) {
                    categories.value = response.body() ?: emptyList()
                } else {
                    Log.e("Error", "Erro ao obter categorias: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.e("Error", "Falha na requisição: ${t.localizedMessage}")
            }
        })
    }

    val selectedExercises = remember { mutableStateMapOf<String, MutableSet<String>>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Exibir categorias carregadas
        categories.value.forEach { category ->
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
                    val selectedExercisesList = selectedExercises.values.flatten()

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

                // Exibir imagem (GIF)
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
