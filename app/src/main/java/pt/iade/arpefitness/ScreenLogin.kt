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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.network.ApiService
import pt.iade.arpefitness.network.LoginRequest
import pt.iade.arpefitness.network.LoginResponse
import pt.iade.arpefitness.network.RetrofitClient
import pt.iade.arpefitness.ui.theme.ArpefitnessTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    // FUNÇÃO DE LOGIN DENTRO DA CLASSE
    private fun performLogin(email: String, password: String) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        val loginRequest = LoginRequest(email, password)

        apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        Toast.makeText(
                            this@ScreenLogin, // ou "applicationContext"
                            "Bem-vindo, ${loginResponse.userName}!",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Salvar token no SharedPreferences (opcional)
                        saveSession(loginResponse.token)
                    }
                } else {
                    Toast.makeText(
                        this@ScreenLogin,
                        "Erro ao fazer login: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(
                    this@ScreenLogin,
                    "Erro de rede: ${t.localizedMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    // FUNÇÃO PARA SALVAR TOKEN
    private fun saveSession(token: String) {
        val sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)
        sharedPreferences.edit().putString("authToken", token).apply()
    }
}

@Composable
fun LoginScreen(onLogin: (String, String) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Imagem de fundo
        Image(
            painter = painterResource(R.drawable.imagelogin),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Gradiente escuro sobre a imagem
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

        // Campos de texto e botões
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
                .padding(top = 120.dp)
        ) {
            // Título
            Text(
                modifier = Modifier.padding(start = 65.dp),
                text = "Arpe\nFITNESS",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Campo de Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("email", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.White),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    cursorColor = Color.White
                )
            )

            // Campo de Senha
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("password", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.White),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    cursorColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            // Link de "Esqueceu a senha?"
            ClickableText(
                modifier = Modifier.padding(start = 190.dp),
                text = androidx.compose.ui.text.AnnotatedString("forgot password?"),
                onClick = {
                    // Ex: abrir outra tela ou mostrar um diálogo
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Botão "Criar conta" -> Exemplo: abre Homepage
            Button(
                onClick = {
                    val intent = Intent(context, Homepage::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF607D8B))
            ) {
                Text(
                    text = "Create account",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Texto "ou"
            Text(
                modifier = Modifier.padding(start = 160.dp),
                text = "or",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Botão "GET STARTED" -> Faz login e, se quiser, vai para outra tela
            Button(
                onClick = {
                    // Primeiro chama a função de login (no callback do Composable)
                    onLogin(email, password)

                    val intent = Intent(context, Homepage::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF607D8B))
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

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {

    ArpefitnessTheme {
        LoginScreen(onLogin = { _, _ ->
        })
    }
}