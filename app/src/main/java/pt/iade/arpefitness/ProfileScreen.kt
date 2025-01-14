package pt.iade.arpefitness

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
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
import java.time.LocalDate

class ProfileScreen : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserProfileScreenContent()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UserProfileScreenContent() {
    var userData by remember {
        mutableStateOf(
            UserData(
                id = 0,
                name = "John ",
                email = "johndoe@email.com",
                password = "",
                gender = "Male",
                dob = LocalDate.of(2003, 2, 17),
                weight = 70,
                height = 175,
                objective = "Build muscle",
                level = "Intermediate"
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cabeçalho
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_icon),
                        contentDescription = "Profile Icon",
                        modifier = Modifier
                            .size(90.dp)
                            .background(Color(0XFF607D8B), CircleShape)
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = userData.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF333333)
                    )
                    Text(
                        text = userData.email,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF666666)
                    )
                }
            }

            // Itens de Perfil
            item { ProfileItem(label = "Gender", value = userData.gender) }
            item { ProfileItem(label = "Year of Birth", value = userData.dob.toString()) }
            item { ProfileItem(label = "Weight (kg)", value = userData.weight.toString()) }
            item { ProfileItem(label = "Height (cm)", value = userData.height.toString()) }
            item { ProfileItem(label = "Objective", value = userData.objective) }
            item { ProfileItem(label = "Level", value = userData.level) }


            // Botão Logout
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        // Ação para logout
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0XFF607D8B),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Log Out",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
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
            .background(Color(0xFF607DB8).copy(alpha = 0.1f), RoundedCornerShape(12.dp)) // Fundo claro
            .padding(16.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0XFF607D8B)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreenContent()
}
