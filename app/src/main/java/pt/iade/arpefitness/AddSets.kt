package pt.iade.arpefitness

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AddSets : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selectedExercises = intent.getStringArrayListExtra("selected_exercises") ?: arrayListOf()
        setContent {
            AddSetsScreen(selectedExercises)
        }
    }
}

@Composable
fun AddSetsScreen(selectedExercises: List<String>) {
    var sets by remember { mutableStateOf(3) }
    val reps = remember { mutableStateListOf("", "", "") } // Inicializa com valores vazios para reps
    val weights = remember { mutableStateListOf("", "", "") } // Inicializa com valores vazios para weights
    var restTime by remember { mutableStateOf(60) }
    val context = LocalContext.current as Activity

    // Ajusta o tamanho das listas quando o número de sets muda
    LaunchedEffect(sets) {
        if (reps.size < sets) {
            reps.addAll(List(sets - reps.size) { "" })
            weights.addAll(List(sets - weights.size) { "" })
        } else if (reps.size > sets) {
            reps.removeRange(sets, reps.size)
            weights.removeRange(sets, weights.size)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Series and Weights",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Controle para número de sets
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Number of sets")

            Spacer(modifier = Modifier.width(16.dp))

            IconButton(onClick = { if (sets > 1) sets-- }) {
                Text("-")
            }
            Text("$sets", fontSize = 18.sp, modifier = Modifier.padding(horizontal = 8.dp))
            IconButton(onClick = { sets++ }) {
                Text("+")
            }
        }

        // Controle para tempo de descanso
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Rest between sets")

            Spacer(modifier = Modifier.width(16.dp))

            IconButton(onClick = { if (restTime > 10) restTime -= 10 }) {
                Text("-")
            }
            Text("${restTime}s", fontSize = 18.sp, modifier = Modifier.padding(horizontal = 8.dp))
            IconButton(onClick = { restTime += 10 }) {
                Text("+")
            }
        }

        // Entrada para sets (reps e weights)
        Text("Sets", fontSize = 20.sp, modifier = Modifier.padding(vertical = 16.dp))
        for (i in 1..sets) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Campo para reps
                Text("${i} Reps:")
                BasicTextField(
                    value = reps.getOrNull(i - 1) ?: "",
                    onValueChange = { value ->
                        if (i - 1 < reps.size) {
                            reps[i - 1] = value
                        }
                    },
                    modifier = Modifier
                        .width(80.dp)
                        .padding(8.dp),
                    singleLine = true
                )

                // Campo para weights
                Text("Load:")
                BasicTextField(
                    value = weights.getOrNull(i - 1) ?: "",
                    onValueChange = { value ->
                        if (i - 1 < weights.size) {
                            weights[i - 1] = value
                        }
                    },
                    modifier = Modifier
                        .width(80.dp)
                        .padding(8.dp),
                    singleLine = true
                )
                Text(text = "kg")
            }
        }

        // Botão "Iniciar treino"
        Button(
            onClick = {
                val intent = Intent(context, DoExercise::class.java).apply {
                    putExtra("sets", sets)
                    putStringArrayListExtra("weights", ArrayList(weights))
                    putStringArrayListExtra("reps", ArrayList(reps))
                    putStringArrayListExtra("selected_exercises", ArrayList(selectedExercises))
                }
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
        ) {
            Text("Iniciar treino")
        }
    }
}


