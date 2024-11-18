package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArpeFitnessApp()
        }
    }
}

@Composable
fun ArpeFitnessApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "WelcomeScreen"
    ) {
        composable("WelcomeScreen") {
            WelcomeScreen(onWelcomeScreenComplete = {
                navController.navigate("Screen_p2") // Navega para Screen_p2
            })
        }
        composable("Screen_p2") {
            Screenp_2() // Composable da próxima tela
        }
    }
}
