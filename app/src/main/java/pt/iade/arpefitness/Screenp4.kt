/*
package pt.iade.arpefitness

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class Screenp4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userData = intent.getSerializableExtra("UserData") as? UserData

        setContent {
            ScreenProfilefour(userData)
        }
    }
}

@Composable
fun ScreenProfilefour(userData: UserData?) {
    // Estado local para controlar includeCardio
    var includeCardio by remember { mutableStateOf(userData?.includeCardio ?: false) }
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF9F9F9)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "My profile",
            fontSize = 24.sp,
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

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp),
            text = "Do you want to perform cardio exercises at the gym?",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF444444).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.padding(25.dp))

        // Card for including cardio
        LevelCard(
            title = "Include cardio in your workouts",
            description = "Cardio exercises will be added before or after workouts",
            onClick = {
                includeCardio = true // Atualiza includeCardio para true
                // Atualiza userData com o novo valor de includeCardio
                val updatedUserData = userData?.copy(includeCardio = includeCardio)
                val intent = Intent(context, Homepage::class.java)
                intent.putExtra("UserData", updatedUserData) // Passa o UserData atualizado
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))


        LevelCard(
            title = "I don't want cardio exercises",
            description = "Cardio exercises will not be added on training days",
            onClick = {
                includeCardio = false // Atualiza includeCardio para false
                // Atualiza userData com o novo valor de includeCardio
                val updatedUserData = userData?.copy(includeCardio = includeCardio)
                val intent = Intent(context, Homepage::class.java)
                intent.putExtra("UserData", updatedUserData) // Passa o UserData atualizado
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Button to navigate to Homepage
        Button(
            onClick = {
                val updatedUserData = userData?.copy(includeCardio = includeCardio)
                val intent = Intent(context, Homepage::class.java)
                intent.putExtra("UserData", updatedUserData)  // Passa o UserData atualizado
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(horizontal = 90.dp)
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
        ) {
            Text(
                text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun LevelCard(title: String, description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp)
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
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0XFFD9D9D9)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenProfilefourPreview() {

    val UserData = UserData(
        id = 1, name = "John",
        email = "john@doe.com",
        password = "password",
        objective = "",
        includeCardio = false
    )


    ScreenProfilefour(userData = UserData)
}
*/