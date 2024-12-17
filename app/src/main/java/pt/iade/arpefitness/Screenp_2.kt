package pt.iade.arpefitness.screens

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.objetive
import pt.iade.arpefitness.ui.components.ObjetiveCard

class Screenp_2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screenp_2 {}
        }
    }
}

@Composable
fun Screenp_2(onNavigateToNextScreen: () -> Unit) {
    val objectives = listOf(
        objetive(
            title = "Beginner",
            description = "Starting practice or less than 6 months experiences",
            onClick = {  }
        ),
        objetive(
            title = "Intermediary",
            description = "Have been practicing bodybuilding for more than 6 months and less than 2 years",
            onClick = {  }
        ),
        objetive(
            title = "Advanced",
            description = "Have been practicing bodybuilding for more than 2 years consistently",
            onClick = { }
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "My profile ",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(15.dp))

        LinearProgressIndicator(
            progress = 0.6f,
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(4.dp),
            color = Color.White,
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            modifier = Modifier.padding(start = 24.dp, end = 12.dp),
            text = "What is your experience practicing bodybuilding?",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000000).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        objectives.forEach { objective ->
            ObjetiveCard(objetive = objective)

            Spacer(modifier = Modifier.height(13.dp))
        }

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = onNavigateToNextScreen,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(horizontal = 90.dp)
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 90.dp)
        ) {
            Text(
                text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
