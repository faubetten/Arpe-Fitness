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

class Screenp2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userData = intent.getSerializableExtra("UserData") as? UserData

        setContent {
            ProfileTwo(userData) {
                // Ação de navegação para a próxima tela
                val nextIntent = Intent(this, Screenp3::class.java)
                nextIntent.putExtra("UserData", userData)
                startActivity(nextIntent)
            }
        }
    }
}

@Composable
fun ProfileTwo(userData: UserData?, onNavigateToNextScreen: () -> Unit) {
    var objective by remember { mutableStateOf(userData?.objective ?: "") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "My Profile",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF607D8B))


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
            text = "What is your objective? ",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF444444).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        ObjetiveCard(
            title = "Hypertrophy",
            description = "Gain muscle mass and bulky muscles",
            onClick = {
                objective = "Hypertrophy"
                val updatedUserData = userData?.copy(objective = objective)
                val intent = Intent(context, Screenp3::class.java)
                intent.putExtra("UserData", updatedUserData) //atualiza os dados do user
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(13.dp))

        ObjetiveCard(
            title = "Muscle Definition",
            description = "Stronger, more rigid and visible muscles",
            onClick = {
                objective = "Muscle Definition"
                val updatedUserData = userData?.copy(objective = objective)
                val intent = Intent(context, Screenp3::class.java)
                intent.putExtra("UserData", updatedUserData) //atualiza os dados do user
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(13.dp))

        ObjetiveCard(
            title = "To lose weight",
            description = "Lose body fat",
            onClick = {
                objective = "To lose weight"
                val updatedUserData = userData?.copy(objective = objective)
                val intent = Intent(context, Screenp3::class.java)
                intent.putExtra("UserData", updatedUserData) //atualiza os dados do user
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(onClick = { onNavigateToNextScreen() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(horizontal = 90.dp)
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
        ) {
            Text( text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun ObjetiveCard(title: String, description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp).height(125.dp)
            .fillMaxWidth()
            .background(Color(0XFF607D8B), shape = RoundedCornerShape(8.dp))
            .clickable { onClick() } // Faz o card ser clicável
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
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0XFFD9D9D9)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Screenp2Preview() {
    ProfileTwo(userData = UserData(
        id = 1,
        name = "John",
        email = "john@doe.com",
        password = "password",
        objective = "Hypertrophy",
        level = "Beginner",
        gender = "",
        dob = 0,
        weight = 72,
        height = 176,
        includeCardio = true
    )) {}
}
