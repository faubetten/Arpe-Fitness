package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.PasswordVisualTransformation


class MainActivity11 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenCreateAccount() {}
        }
    }
}

@Composable
fun ScreenCreateAccount(onCreateAccountComplete: () -> Unit = {}) {
    // Variáveis de estado para armazenar as entradas do usuário
    var firstName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
    ) {
        Column(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Create Account",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = onCreateAccountComplete,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 2.dp)
                ) {
                    Text(
                        text = "Sign in with Google",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    modifier = Modifier.padding(12.dp),
                    color = Color.White,
                    text = "or",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal
                )
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de entrada para "First name"
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "First name",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                placeholder = { Text("Enter your first name") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White),
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),

                )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de entrada para "Email"
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Email",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Enter your email") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                ),
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de entrada para "Password"
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Password",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Create a password") },
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(  unfocusedContainerColor = Color.White),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onCreateAccountComplete,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Create Account",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                TextButton(
                    onClick = onCreateAccountComplete,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = "Log in",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenCreateAccountPreview() {
    ScreenCreateAccount()
}




