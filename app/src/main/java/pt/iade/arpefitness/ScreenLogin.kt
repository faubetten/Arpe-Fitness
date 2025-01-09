package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.network.ApiService
import pt.iade.arpefitness.network.LoginRequest
import pt.iade.arpefitness.network.LoginResponse
import pt.iade.arpefitness.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import pt.iade.arpefitness.ui.theme.ArpefitnessTheme


class ScreenLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArpefitnessTheme {
                LoginScreen(onLogin = { email, password ->
                    performLogin(email, password)
                })
            }
        }
    }

    private fun performLogin(email: String, password: String) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        val loginRequest = LoginRequest(email, password)

        apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        Toast.makeText(applicationContext, "Bem-vindo, ${loginResponse.userName}!", Toast.LENGTH_SHORT).show()

                        // Salvar token no SharedPreferences (opcional)
                        saveSession(loginResponse.token)
                    }
                } else {
                    Toast.makeText(applicationContext, "Erro ao fazer login: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Erro de rede: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun saveSession(token: String) {
        val sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)
        sharedPreferences.edit().putString("authToken", token).apply()
    }
}

@Composable
fun LoginScreen(onLogin: (String, String) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.imagelogin),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.5f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
                .padding(top = 120.dp),
        ) {
            Text(
                text = "Arpe\nFITNESS",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.Gray,
                    cursorColor = Color.White
                )
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.Gray,
                    cursorColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            val context = LocalContext.current

            Button(
                onClick = { val intent = Intent(context, Homepage::class.java)
                    context.startActivity(intent)
                    onLogin(email, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text(
                    text = "GET STARTED",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
