package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class CustomWorkout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomWorkoutNavHost()
        }
    }
}

@Composable
fun CustomWorkoutNavHost() {
    val navController = rememberNavController()

    // Defina seu NavHost aqui com as rotas
    NavHost(
        navController = navController,
        startDestination = "customWorkout"
    ) {
        composable("customWorkout") {
            CustomWorkoutScreen(navController)
        }
        composable("SelectExercise") {

            SelectExerciseScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomWorkoutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Custom Workout",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF999999),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "My Workout",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            NavigateButton(navController)
        }
    }
}

@Composable
fun NavigateButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("SelectExercise") }, // Navegando para a tela SelectExercise
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF999999),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp)
            .height(60.dp)
    ) {
        Text(
            text = "Create Your Own Workout Routine",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add",
            tint = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectExerciseScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Select Exercise")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF999999),
                    titleContentColor = Color.White
                )
            )
        }
    ) {

        Text(
            text = "Select your exercises here",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomWorkoutPreview() {
    CustomWorkoutScreen(rememberNavController())
}
