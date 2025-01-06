package pt.iade.arpefitness

import android.os.Bundle
import android.os.CountDownTimer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

class DoExercise : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val restTime = intent.getIntExtra("restTime", 30)
        val sets = intent.getIntExtra("sets", 0)
        val weights = intent.getStringArrayListExtra("weights") ?: arrayListOf()
        val reps = intent.getStringArrayListExtra("reps") ?: arrayListOf()
        val selectedExercises = intent.getStringArrayListExtra("selected_exercises") ?: arrayListOf()


        setContent {
            // Aqui, envolvemos o valor de restTime em mutableStateOf para torná-lo reativo
            val restTimeState = remember { mutableIntStateOf(restTime) }
            var currentExerciseIndex by remember { mutableIntStateOf(0) }
            var showRestTimer by remember { mutableStateOf(false) }

            if (showRestTimer) {
                RestTimerActivity(
                    restTime = restTimeState.intValue, // Passando o valor de restTime obtido na Intent
                    onRestFinish = {
                        // Quando o descanso terminar, mostre o próximo exercício
                        if (currentExerciseIndex < selectedExercises.size - 1) {
                            currentExerciseIndex++
                        }
                        showRestTimer = false
                    }
                )
            } else {
                DoingExercise(
                    exercises = selectedExercises,
                    sets = sets,
                    weights = weights,
                    reps = reps,
                    currentExerciseIndex = currentExerciseIndex,
                    onPrevious = { if (currentExerciseIndex > 0) currentExerciseIndex-- },
                    onNext = {
                        // Exiba o timer de descanso antes de ir para o próximo exercício
                        showRestTimer = true
                    },
                    onFinish = { finish() }
                )
            }
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



            Spacer(modifier = Modifier.height(16.dp))

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
                    Text(text = "Finish")
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

@Composable
fun RestTimerActivity(
    restTime: Int,
    onRestFinish: () -> Unit
) {
    var timeLeft by remember { mutableStateOf(restTime) }
    var isRunning by remember { mutableStateOf(false) }
    var timer: CountDownTimer? by remember { mutableStateOf(null) }

    // Função para iniciar o cronômetro
    fun startTimer() {
        if (isRunning) return

        timer = object : CountDownTimer(timeLeft * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                timeLeft = 0
                onRestFinish() // Chama a função para ir para o próximo exercício
            }
        }
        timer?.start()
        isRunning = true
    }

    fun stopTimer() {
        timer?.cancel()
        isRunning = false
    }

    fun SkipRest(){
        stopTimer()
        timeLeft = 0
        onRestFinish()
    }

    // Layout para exibir o cronômetro
    Box(
        modifier = Modifier
            .fillMaxSize().
            background(Color(0xFFEEEEEE)
            )
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

            Spacer(modifier = Modifier.width(16.dp))

            Row {
                Button(
                    onClick = { startTimer() },
                    enabled = !isRunning,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text(text = "Start")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { SkipRest() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray, contentColor = Color.LightGray)
                ) {
                    Text(text = "Skip")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { stopTimer() },
                    enabled = isRunning,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(text = "Stop")
                }
            }
        }
    }
}
