package pt.iade.arpefitness.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pt.iade.arpefitness.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFF999999)
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
