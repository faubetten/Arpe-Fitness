package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.Levelcard
import pt.iade.arpefitness.ui.components.LevelCard

class Screenp_4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenProfileFour()
        }
    }
}

@Composable
fun ScreenProfileFour() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título da página
        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "My profile",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Barra de progresso
        LinearProgressIndicator(
            progress = 0.8f,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .height(4.dp)
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth(),
            color = Color.White
        )

        Spacer(modifier = Modifier.height(5.dp))

        // Pergunta
        Text(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp),
            text = "Do you want to perform cardio exercises at the gym?",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000000).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.padding(30.dp))

        val includeCardio = Levelcard(
            title = "Include cardio in your workouts",
            description = "Cardio exercises will be added before or after workouts",
            onClick = {}
        )

        val noCardio = Levelcard(
            title = "I don't want cardio exercises",
            description = "Cardio exercises will not be added on training days",
            onClick = {}
        )

        LevelCard(
            levelcard = includeCardio,
            onClick = {
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        LevelCard(
            levelcard = noCardio,
            onClick = {
            }
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = { Homepage() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(horizontal = 90.dp)
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenProfileFourPreview() {
    ScreenProfileFour()
}
