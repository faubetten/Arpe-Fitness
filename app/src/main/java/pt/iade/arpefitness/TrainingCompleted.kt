package pt.iade.arpefitness

import TrainingSession
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TrainingCompleted : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val caloriesBurned = intent.getDoubleExtra("caloriesBurned", 0.0).toFloat()
        val trainingTime = intent.getIntExtra("trainingTime", 0).toLong()


        val trainingSession = TrainingSession(
            date = System.currentTimeMillis(),
            caloriesBurned = caloriesBurned,
            trainingTime = trainingTime
        )

        setContent {
            TrainingCompletedScreen(
                trainingSession = trainingSession,
                onBackHomeClick = {
                    val intent = Intent(this, Homepage::class.java)
                    startActivity(intent)
                    finish()
                }
            )
        }
    }
}

@Composable
fun TrainingCompletedScreen(
    trainingSession: TrainingSession,
    onBackHomeClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) { padding ->
        Column(
            modifier = Modifier
                .background(Color(0xFFF5F5F5))
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TRAINING COMPLETED",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TrainingInfoRow(
                    label = "CALORIES BURNED",
                    value = String.format("%.2f", trainingSession.caloriesBurned) + " KCAL"
                )
                TrainingInfoRow(
                    label = "TRAINING TIME",
                    value = trainingSession.getFormattedTime() + " MIN"
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = onBackHomeClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF607D8B)),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Text(
                        text = "Back Home",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

// tempo de treino
fun TrainingSession.getFormattedTime(): String {
    val minutes = trainingTime / 60
    val seconds = trainingTime % 60
    return String.format("%02d:%02d", minutes, seconds)
}

@Composable
fun TrainingInfoRow(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTrainingCompletedScreen() {
    val trainingSession = TrainingSession(
        date = System.currentTimeMillis(),
        caloriesBurned = 158.03f,
        trainingTime = 748 // 12 minutos e 28 segundos
    )

    TrainingCompletedScreen(
        trainingSession = trainingSession,
        onBackHomeClick = {}
    )
}
