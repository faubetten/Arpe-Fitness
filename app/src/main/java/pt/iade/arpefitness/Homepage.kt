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


class Homepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}

@Composable
fun MainView() {
    // Exibindo apenas um texto no topo em vez de usar Scaffold e TopAppBar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título centralizado no topo
        Text(
            text = "WORKOUTS",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        )

        // O conteúdo original da página
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WorkoutCard(
                imageRes = R.drawable.custom, // Use uma imagem de placeholder
                description = "Custom workout"
            )

            Text(
                text = "My training plan",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF000000).copy(alpha = 0.9f)
            )

            WorkoutCard(
                imageRes = R.drawable.plan, // Use uma imagem de placeholder
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
            .aspectRatio(2f),
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

/* acabar de fazer o bottombar da tela
@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFFD3D3D3)
    ) {
        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.home_icon), contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { /* nome */ }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.statics_icon), contentDescription = "Statics") },
            label = { Text("Statics") },
            selected = false,
            onClick = { /* nome da tela */ }
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(R.drawable.profile_icon), contentDescription = "Profile") },
            label = { Text("Perfil") },
            selected = false,
            onClick = { /* nome da tela*/ }
        )
    }
}*/

@Preview(showBackground = true)
@Composable
fun PreviewMainView() {
    MainView()
}