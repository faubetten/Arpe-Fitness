package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class Homepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Home()
        }
    }
}

@Composable
fun Home() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen() }
            composable("statistics") { StatisticsScreen() }
            composable("profile") { Profilescreen() }
        }
    }
}

@Composable
fun HomeScreen() {
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
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WorkoutCard(
                imageRes = R.drawable.custom, // Imagem de exemplo
                description = "Custom workout"
            )

            Text(
                text = "My training plan",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF000000).copy(alpha = 0.9f)
            )

            WorkoutCard(
                imageRes = R.drawable.plan, // Imagem de exemplo
                description = "Hypertrophy"
            )
        }
    }
}



@Composable
fun WorkoutCard(imageRes: Int, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .height(60.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {
            Image(
                painter = painterResource(imageRes),
                contentDescription = description,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = description,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFF999999)
    ) {
        // Botão Home
        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.home_icon), contentDescription = "Home") },
            label = { Text("Home") },
            modifier = Modifier.size(30.dp),
            selected = false,
            onClick = { navController.navigate("home") }
        )
        // Botão Estatísticas
        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.statics_icon), contentDescription = "Statistics") },
            label = { Text("Statistics") },
            modifier = Modifier.size(30.dp),
            selected = false,
            onClick = { navController.navigate("statistics") }
        )
        // Botão Perfil
        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.profile_icon), contentDescription = "Profile") },
            label = { Text("Profile") },
            modifier = Modifier.size(30.dp),
            selected = false,
            onClick = { navController.navigate("profile") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    Home()
}
