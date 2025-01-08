package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class WelcomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WelScreen()
        }
    }
}

@Composable
fun WelScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        Image(
            painter = painterResource(id = R.drawable.halter_icon),
            contentDescription = "Icone de Halteres",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(200.dp)
                .alpha(0.1f)
                .padding(16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Arpe Fitness",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF607D8B),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Text(
                text = "Let's create a personalized plan to help you achieve your fitness goals.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    val intent = Intent(context, Screenp1::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF607D8B),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelScreen()
}
