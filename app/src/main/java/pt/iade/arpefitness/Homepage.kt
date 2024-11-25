package pt.iade.arpefitness


import BMICalculator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("statistics") { BMICalculator() }
            composable("profile") { Profilescreen() }
            composable("custom") { CustomWorkoutScreen(navController) }
            composable ("select_exercise"){ExercisesScreen()}

        }
    }
}



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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            WorkoutCard(
                navController = navController,
                imageRes = R.drawable.custom,
                description = "Custom workout",
                destination = "custom",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(text = "My training plan",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
                )

            WorkoutCard(
                navController = navController,
                imageRes = R.drawable.plan,
                description = "plan",
                destination = "statistics",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            WorkoutRow(navController)
        }
    }
}

@Composable
fun WorkoutCard(
    navController: NavController,
    imageRes: Int,
    description: String,
    destination: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { navController.navigate(destination) },
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
                fontSize = 18.sp,
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
fun WorkoutRow(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer (modifier = Modifier.height(10.dp))

        WorkoutCard(
            navController = navController,
            imageRes = R.drawable.hit,
            description = "Hit",
            destination = "statistics",
            modifier = Modifier
                .weight(0.5f)
                .aspectRatio(1f)
        )

        WorkoutCard(
            navController = navController,
            imageRes = R.drawable.abs,
            description = "Abs",
            destination = "statistics",
            modifier = Modifier
                .weight(0.5f)
                .aspectRatio(1f)
        )
    }
}



@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFF999999)
    ) {

        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.home_icon),
                contentDescription = "Home",
                modifier = Modifier.size(20.dp)) },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home") }
        )

        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.statics_icon),
                contentDescription = "Statistics",
                modifier = Modifier.size(20.dp)) },
            label = { Text("Statistics") },
            selected = false,
            onClick = { navController.navigate("statistics") }
        )

        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.profile_icon),
                contentDescription = "Profile",
                modifier = Modifier.size(20.dp)) },
            label = { Text("Profile") },

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
