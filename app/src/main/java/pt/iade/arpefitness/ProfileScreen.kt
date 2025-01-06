package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.UserData

class ProfileScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserProfileScreenContent()
        }
    }
}

@Composable
fun UserProfileScreenContent() {
    // Estado do usuário
    var userData by remember {
        mutableStateOf(
            UserData(
                name = "",
                email = "" ,
                password = "" ,
                gender = "Male",
                dob = 1990,
                weight = 70,
                height = 175,
                objective = "Build muscle",
                level = "Intermediate",
                includeCardio = true
            )
        )
    }

    // Tela do perfil
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
    ) {
        // LazyColumn para conteúdo scrollable
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cabeçalho com ícone de perfil e nome
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Ícone de perfil
                    Image(
                        painter = painterResource(id = R.drawable.profile_icon),
                        contentDescription = "Profile Icon",
                        modifier = Modifier
                            .size(64.dp)
                            .background(Color.Gray, CircleShape)
                            .padding(8.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    // Nome do usuário
                    Text(
                        text = "John Doe", // Substitua pelo nome do usuário
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF000000).copy(alpha = 0.8f)
                    )
                }
            }

            // Exibição dos dados do usuário como itens scrollable
            item { ProfileItem(label = "Gender", value = userData.gender) }
            item { ProfileItem(label = "Year of Birth", value = userData.dob.toString()) }
            item { ProfileItem(label = "Weight (kg)", value = userData.weight.toString()) }
            item { ProfileItem(label = "Height (cm)", value = userData.height.toString()) }
            item { ProfileItem(label = "Objective", value = userData.objective) }
            item { ProfileItem(label = "Level", value = userData.level) }
            item { ProfileItem(label = "Include Cardio", value = if (userData.includeCardio) "Yes" else "No") }

            // Botão para deslogar
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        // Ação para terminar a sessão
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF999999),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Log out", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color(0xFF999999), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF000000).copy(alpha = 0.8f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreenContent()
}
