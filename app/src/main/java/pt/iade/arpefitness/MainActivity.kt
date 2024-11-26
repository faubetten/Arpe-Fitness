package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.ui.theme.ArpefitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArpefitnessTheme {
                FitnessApp()
            }
        }
    }
}

@Composable
fun FitnessApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        TrainingPlanSelector(Modifier.padding(innerPadding))
    }
}

@Composable
fun TrainingPlanSelector(modifier: Modifier = Modifier) {
    var selectedPlan by remember { mutableStateOf<String?>(null) }
    var planDetails by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF0F0F0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select Your Training Plan",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                selectedPlan = "Hypertrophy"
                planDetails = generatePlan("Hypertrophy")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Hypertrophy Plan")
        }

        Button(
            onClick = {
                selectedPlan = "Definition"
                planDetails = generatePlan("Definition")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Definition Plan")
        }

        Button(
            onClick = {
                selectedPlan = "Weight Loss"
                planDetails = generatePlan("Weight Loss")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Weight Loss Plan")
        }

        Spacer(modifier = Modifier.height(24.dp))

        selectedPlan?.let {
            Text(
                text = "Selected Plan: $it",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        planDetails?.let {
            Text(
                text = it,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

fun generatePlan(planType: String): String {
    return when (planType) {
        "Hypertrophy" -> """
            Hypertrophy Plan:
            - Bench Press: 4x8-12
            - Dumbbell Fly: 3x10-12
            - Squat: 4x8-12
            - Crunches: 3x15-20
            Rest: 45 seconds
        """.trimIndent()
        "Definition" -> """
            Definition Plan:
            - Pulldown: 4x12-15
            - Face Pull: 3x12-15
            - Leg Press: 3x12-15
            - Plank: 3x30-60s
            Rest: 30 seconds
        """.trimIndent()
        "Weight Loss" -> """
            Weight Loss Plan:
            - Push-Up: 3x20
            - Pull-Ups: 3x15
            - Deadlift: 3x12
            - Burpees: 3x15
            Rest: 15-30 seconds
        """.trimIndent()
        else -> "Invalid plan type."
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFitnessApp() {
    ArpefitnessTheme {
        FitnessApp()
    }
}
