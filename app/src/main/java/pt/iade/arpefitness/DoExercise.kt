package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DoExercise : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Receber os valores passados pelo Intent
      //  val exercises = intent.getStringArrayListExtra("exercises") ?: arrayListOf()
        val sets = intent.getIntExtra("sets", 0)
        val weights = intent.getStringArrayListExtra("weights") ?: arrayListOf()
        val reps = intent.getStringArrayListExtra("reps") ?: arrayListOf()
        val selectedExercises = intent.getStringArrayListExtra("selected_exercises") ?: arrayListOf()


        setContent {
            var currentExerciseIndex by remember { mutableStateOf(0) } // Índice atual do exercício

            DoingExercise(
                exercises = selectedExercises,
                sets = sets,
                weights = weights,
                reps = reps,
                currentExerciseIndex = currentExerciseIndex,
                onPrevious = { if (currentExerciseIndex > 0) currentExerciseIndex-- },
                onNext = { if (currentExerciseIndex < selectedExercises.size - 1) currentExerciseIndex++ },
                onFinish = { finish() }
            )
        }
    }
}

@Composable
fun DoingExercise(
    exercises: List<String>,
    sets: Int,
    weights: List<String>,
    reps: List<String>,
    currentExerciseIndex: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onFinish: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF999999))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            // Nome do exercício atual
            Text(
                text = exercises[currentExerciseIndex],
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Imagem do exercício
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

            // Exibição de sets, reps e weights
            Text(
                text = "Sets",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column {
                repeat(sets) { index ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${index + 1} Reps: ${reps.getOrNull(index) ?: ""}",
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Load: ${weights.getOrNull(index) ?: ""} kg",
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Como executar o exercício
            Text(
                text = "How to perform this exercise",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column {
                repeat(3) { index ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${index + 1}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color.Black)
                                .padding(4.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "• description",
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            // Navegação entre exercícios
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onPrevious,
                    enabled = currentExerciseIndex > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "<")
                }

                Button(
                    onClick = onFinish,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Finalizar treino")
                }

                Button(
                    onClick = onNext,
                    enabled = currentExerciseIndex < exercises.size - 1,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = ">")
                }
            }
        }
    }
}
