package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.UserData
import pt.iade.arpefitness.models.UserResponse
import pt.iade.arpefitness.models.UserUpdateRequest
import pt.iade.arpefitness.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Screenp3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userData = intent.getSerializableExtra("UserData") as? UserData




        setContent {
            Screenp_3(userData = userData) { updatedUserData ->
                // Aqui você pode implementar a lógica para passar à próxima tela ou ação
                Toast.makeText(this, "Updated User Data: $updatedUserData", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun Screenp_3(userData: UserData?, onNavigateToNextScreen: (UserData) -> Unit = {}) {
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
            progress = 0.9f,
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

        val levels = listOf(
            "Beginner" to "Starting practice or less than 6 months experience",
            "Intermediate" to "Have been practicing bodybuilding for more than 6 months and less than 2 years",
            "Advanced" to "Have been practicing bodybuilding for more than 2 years consistently"
        )

        levels.forEach { (title, description) ->
            Spacer(modifier = Modifier.height(13.dp))
            ObjetiveCard2(
                title = title,
                description = description,
                onClick = {
                    level = title
                    userData?.let {
                       val intent = Intent(context,Homepage::class.java)
                        context.startActivity(intent)
                    }
                }
            )
        }

    }
}
/*
fun sendUpdatedUserToBackend(userData: UserData, context: android.content.Context) {
    val userUpdateRequest = UserUpdateRequest(
        userName = userData.name,
        userEmail = userData.email,
        userBirthDate = userData.dob.toString(),
        userGender = userData.gender,
        userHeight = userData.height.toDouble(),
        userWeight = userData.weight.toDouble(),
        userGoal = userData.objective,
        userExperience = userData.level
    )

    RetrofitClient.apiService.updateUser(userData.id, userUpdateRequest)
        .enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {

                    Toast.makeText(context, "User updated successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Failed to update user.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
}
*/
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


