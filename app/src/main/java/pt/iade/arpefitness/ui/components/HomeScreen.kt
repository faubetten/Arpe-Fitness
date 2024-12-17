package pt.iade.arpefitness.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pt.iade.arpefitness.R

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WORKOUTS",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        val customWorkout = pt.iade.arpefitness.models.WorkoutCard(
            imageRes = R.drawable.custom,
            description = "Custom workout",
            destination = "custom"
        )
        WorkoutCard(
            navController = navController,
            workoutCard = customWorkout,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "My training plan",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold
        )

        val workouts = listOf(
            pt.iade.arpefitness.models.WorkoutCard(R.drawable.hit, "Hit", "statistics"),
            pt.iade.arpefitness.models.WorkoutCard(R.drawable.abs, "Abs", "statistics")
        )
        WorkoutRow(navController = navController, workouts = workouts)
    }
}
