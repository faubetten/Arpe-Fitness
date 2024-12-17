package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import pt.iade.arpefitness.ui.Home

class Homepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Cria um NavController para gerenciar a navegação
            val navController = rememberNavController()
            // Exibe o componente Home com o controlador de navegação
            Home(navController = navController)
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    Home()
}
*/