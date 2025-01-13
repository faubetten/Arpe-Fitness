package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.UserData

class Screenp3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userData = intent.getSerializableExtra("UserData") as? UserData

        setContent {
            Screenp_3(userData = userData) // Passando o userData para o composable
        }
    }
}

@Composable
fun Screenp_3(userData: UserData?, onNavigateToNextScreen: () -> Unit = {}) {
    var level by remember { mutableStateOf(userData?.level ?: "") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "My profile ",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF607D8B)
        )

        Spacer(modifier = Modifier.height(15.dp))

        LinearProgressIndicator(
            progress = 0.6f,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(6.dp)
                .clip(RoundedCornerShape(50.dp)),
            color = Color(0xFF607D8B),
            trackColor = Color(0xFFD9D9D9)
        )

        Spacer(modifier = Modifier.padding(15.dp))

        Text(
            modifier = Modifier.padding(start = 24.dp, end = 12.dp),
            text = "What is your experience practicing bodybuilding?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF444444).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        ObjetiveCard2(
            title = "Beginner",
            description = "Starting practice or less than 6 months experience",
            onClick = {

              level = "Beginner"
                val updatedUserData = userData?.copy(level = level)
                val intent = Intent(context, Homepage::class.java)
                intent.putExtra("UserData", updatedUserData) // Passa o UserData atualizado
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(13.dp))

        ObjetiveCard2(
            title = "Intermediary",
            description = "Have been practicing bodybuilding for more than 6 months and less than 2 years",
            onClick = {
                level = "Intermediary"
                val updatedUserData = userData?.copy(level = level)
                val intent = Intent(context, Homepage::class.java)
                intent.putExtra("UserData", updatedUserData) // Passa o UserData atualizado
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(13.dp))

        ObjetiveCard2(
            title = "Advanced",
            description = "Have been practicing bodybuilding for more than 2 years consistently",
            onClick = {
                level = "Advanced"
                val updatedUserData = userData?.copy(level = level)
                val intent = Intent(context, Homepage::class.java)
                intent.putExtra("UserData", updatedUserData) // Passa o UserData atualizado
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(60.dp))

        /*Button(
            onClick = { onNavigateToNextScreen() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(horizontal = 90.dp)
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
        ) {
            Text(
                text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }*/
    }
}

@Composable
fun ObjetiveCard2(title: String, description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp).height(125.dp)
            .fillMaxWidth()
            .background(Color(0XFF607D8B), shape = RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = description,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0XFFD9D9D9)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Screenp_3Preview() {
    Screenp_3(userData = UserData( id = 1,
        name = "John",
        email = "john@doe.com",
        password = "password",
        objective = "Hypertrophy",
        level = "Beginner",
        gender = "",
        dob = 0,
        weight = 72,
        height = 176,
        includeCardio = true))
}
