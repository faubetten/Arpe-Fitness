package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
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
            WelcomeScreen() {
                Screenp_2()
            }
        }
    }
}

@Composable
fun WelcomeScreen(onWelcomeScreenComplete: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
    ) {

        Image(
            painter = painterResource(id = R.drawable.halter_icon),
            contentDescription = "Icone de Halteres",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(200.dp)
                .alpha(0.2f)
                .padding(16.dp)
        )

        Column(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp)
                .padding(top = 160.dp)
                .fillMaxWidth()

        ) {
            Text(
                text = "Welcome to",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Arpe Fitness",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom =60.dp)
            )

            Text(
                text = "We want to provide the best experience and help you achieve your health and fitness goals. To do this, we need to know a little more about you!",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 30.dp)
            )

            Text(
                text = "Share some basic information so we can create a training and eating plan perfectly tailored to your needs and preferences. All the information provided will be treated with complete confidentiality and will only be used to personalize your fitness journey.",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 60.dp)
            )

            Text(
                text = "Shall we start?",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 60.dp)
            )

            Button(
                onClick = onWelcomeScreenComplete,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 90.dp) // Define padding horizontal ao redor do botão
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen() {

    }
}

