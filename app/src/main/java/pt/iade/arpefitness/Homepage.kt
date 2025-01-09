package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.iade.arpefitness.models.ExercisePlan
import pt.iade.arpefitness.models.UserData

class Homepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userData = intent.getSerializableExtra("UserData") as? UserData



        setContent {
            
            Home(userData ?: UserData(
                id = 0,
                name = "",
                email = "",
                password = "",
                gender = "",
                dob = 0,
                weight = 0,
                height = 0,
                objective = "",
                level = "",
                includeCardio = false
            ))
        }
    }
}

@Composable
fun Home(userData: UserData) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen(navController, userData) }
            composable("profileone") { ProfileOne() }
            composable("statistics") { StatisticsContent() }
            composable("select_exercise"){ExercisesScreen()}
            composable("profile") { UserProfileScreenContent() }
            composable("custom") { CustomWorkoutScreen(navController) }
            composable("WorkoutPlan") {
                val workoutPlan = generateWorkoutPlan(userData.objective)
                WorkoutSelectionScreen(workoutPlan = workoutPlan)
            }
            }
        }
    }

@Composable
fun HomeScreen(navController: NavController, userData: UserData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFF5F5F5))
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
                userData = userData,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "My training plan",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )

            WorkoutCard(
                navController = navController,
                imageRes = R.drawable.plan,
                description = "Plan",
                destination = "WorkoutPlan",
                userData = userData,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(5.dp))

            WorkoutRow(navController, userData)
        }
    }
}

@Composable
fun WorkoutCard(
    modifier: Modifier,
    navController: NavController,
    imageRes: Int,
    description: String,
    destination: String,
    userData: UserData
) {
    Card(
        modifier = modifier
            .height(200.dp)
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
fun WorkoutRow(navController: NavController, userData: UserData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WorkoutCard(
            navController = navController,
            imageRes = R.drawable.hit,
            description = "Hit",
            destination = "statistics",
            userData = userData,
            modifier = Modifier
                .weight(1f) // Cada card ocupa metade do espaço disponível
        )

        WorkoutCard(
            navController = navController,
            imageRes = R.drawable.abs,
            description = "Abs",
            destination = "statistics",
            userData = userData,
            modifier = Modifier
                .weight(1f) // Cada card ocupa metade do espaço disponível
        )
    }
}



@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFFD9D9D9)
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.home_icon),
                    contentDescription = "Home",
                    modifier = Modifier.size(20.dp)
                )
            },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home") }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.statics_icon),
                    contentDescription = "Statistics",
                    modifier = Modifier.size(20.dp)
                )
            },
            label = { Text("Statistics") },
            selected = false,
            onClick = { navController.navigate("statistics") }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.profile_icon),
                    contentDescription = "Profile",
                    modifier = Modifier.size(20.dp)
                )
            },
            label = { Text("Profile") },
            selected = false,
            onClick = { navController.navigate("profile") }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    val userData = UserData( 1, name = "John",
        email = "john@doe.com",
        password = "password",
        objective = "Hypertrophy",
        level = "Beginner",
        includeCardio = true)


    Home(userData = userData )
}