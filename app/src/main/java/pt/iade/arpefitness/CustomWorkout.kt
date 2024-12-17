package pt.iade.arpefitness

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pt.iade.arpefitness.ui.components.CustomWorkoutButton
import pt.iade.arpefitness.ui.components.TopBar

@Composable
fun CustomWorkoutScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar(title = "Custom Workout") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "My Workout",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomWorkoutButton(
                onClick = { navController.navigate("select_exercise") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomWorkoutScreenPreview() {
    CustomWorkoutScreen(navController = rememberNavController())
}
