package pt.iade.arpefitness.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pt.iade.arpefitness.models.WorkoutCard

@Composable
fun WorkoutRow(
    navController: NavController,
    workouts: List<WorkoutCard>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        workouts.forEach { workout ->
            WorkoutCard(
                navController = navController,
                workoutCard = workout,
                modifier = Modifier
                    .weight(0.5f)
                    .aspectRatio(1f)
            )
        }
    }
}
