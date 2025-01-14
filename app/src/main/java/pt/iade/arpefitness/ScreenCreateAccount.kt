package pt.iade.arpefitness

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.UserRequest
import pt.iade.arpefitness.models.UserResponse
import pt.iade.arpefitness.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScreenCreateAccount : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CreateAccount()
        }
    }
}

@Composable
fun CreateAccount(onCreateAccountComplete: () -> Unit = {}) {
    // Variáveis de estado para armazenar as entradas do usuário
    var firstName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECEFF1))
            .padding(top = 150.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Create Account",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF607D8B)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo de entrada para "First Name"
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "First name",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF607D8B)
            )
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                placeholder = { Text("Enter your first name") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF607D8B),
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de entrada para "Email"
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Email",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF607D8B)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Enter your email") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF607D8B),
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de entrada para "Password"
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Password",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF607D8B)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Create a password") },
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF607D8B),
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botão para criar conta
            Button(
                onClick = {
                    if (firstName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                        createUser(firstName, email, password, context)
                    } else {
                        Toast.makeText(context, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF607D8B),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Create Account",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

fun createUser(userName: String, userEmail: String, userPassword: String, context: Context) {
    val userRequest = UserRequest(
        userName = userName,
        userEmail = userEmail,
        userPassword = userPassword
    )

    RetrofitClient.apiService.createUser(userRequest)
        .enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val userId = response.body()?.userId
                    Toast.makeText(context, "Account created! User ID: $userId", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, WelcomeScreen::class.java)
                    intent.putExtra("userId", userId)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(
                        context,
                        "Failed to create account: ${response.errorBody()?.string()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
}

@Preview(showBackground = true)
@Composable
fun ScreenCreateAccountPreview() {
    CreateAccount()
}
