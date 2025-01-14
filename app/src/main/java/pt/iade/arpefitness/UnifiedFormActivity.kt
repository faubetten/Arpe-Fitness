package pt.iade.arpefitness

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.UserUpdateRequest
import pt.iade.arpefitness.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.util.*

class UnifiedFormActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userId = intent.getIntExtra("userId", 0) // Recebe o userId passado para esta tela
        val userName = intent.getStringExtra("userName") ?: ""
        val userEmail = intent.getStringExtra("userEmail") ?: ""

        setContent {
            UnifiedFormScreen(userId = userId, userName = userName, userEmail = userEmail)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnifiedFormScreen(userId: Int, userName: String, userEmail: String) {
    var gender by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf<LocalDate?>(null) }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var objective by remember { mutableStateOf("") }
    var level by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, selectedYear, selectedMonth, selectedDay ->
            dob = LocalDate.of(selectedYear, selectedMonth + 1, selectedDay)
        },
        year,
        month,
        day
    )

    fun isValidForm(): Boolean {
        return dob != null &&
                weight.isNotEmpty() &&
                height.isNotEmpty() &&
                objective.isNotEmpty() &&
                level.isNotEmpty() &&
                gender.isNotEmpty()
    }

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Complete Your Profile",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF444444),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Gender Selection
        item {
            Text("Sex", fontWeight = FontWeight.SemiBold, color = Color(0xFF444444), fontSize = 20.sp)
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                RadioButtonWithLabel(selected = (gender == "M"), label = "Male", onClick = { gender = "M" })
                RadioButtonWithLabel(selected = (gender == "F"), label = "Female", onClick = { gender = "F" })
            }
        }

        // Date of Birth Selection
        item {
            Text("Date of Birth", fontWeight = FontWeight.SemiBold, color = Color(0xFF444444), fontSize = 20.sp)
            Button(
                onClick = { datePickerDialog.show() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFF444444)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = dob?.toString() ?: "Select your date of birth", fontSize = 16.sp)
            }
        }

        // Weight Field
        item {
            TextFieldWithTitle(title = "Weight (kg)", value = weight, onValueChange = { weight = it }, placeholder = "Enter your weight")
        }

        // Height Field
        item {
            TextFieldWithTitle(title = "Height (cm)", value = height, onValueChange = { height = it }, placeholder = "Enter your height")
        }

        // Objective Selection
        item {
            Text("What is your objective?", fontWeight = FontWeight.SemiBold, color = Color(0xFF444444), fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            ObjectiveCard(title = "Hypertrophy", onClick = { objective = "Hypertrophy" })
            Spacer(modifier = Modifier.height(8.dp))
            ObjectiveCard(title = "Muscle Definition", onClick = { objective = "Muscle Definition" })
            Spacer(modifier = Modifier.height(8.dp))
            ObjectiveCard(title = "To lose weight", onClick = { objective = "To lose weight" })
        }

        // Experience Level Selection
        item {
            Text("Experience Level", fontWeight = FontWeight.SemiBold, color = Color(0xFF444444), fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            ObjectiveCard(title = "Beginner", onClick = { level = "Beginner" })
            Spacer(modifier = Modifier.height(8.dp))
            ObjectiveCard(title = "Intermediary", onClick = { level = "Intermediary" })
            Spacer(modifier = Modifier.height(8.dp))
            ObjectiveCard(title = "Advanced", onClick = { level = "Advanced" })
        }

        // Submit Button
        item {
            Button(
                onClick = {
                    if (isValidForm()) {val intent = Intent(context, Homepage::class.java)
                        context.startActivity(intent)
                        val userUpdateRequest = dob?.toString()?.let {
                            UserUpdateRequest(
                                userBirthDate = it,
                                userGender = gender,
                                userHeight = height.toDoubleOrNull() ?: 0.0,
                                userWeight = weight.toDoubleOrNull() ?: 0.0,
                                userGoal = objective,
                                userExperience = level,
                                userName = userName,
                                userEmail = userEmail
                            )

                        }
                        if (userUpdateRequest != null) {
                            sendUpdatedUserToBackend(userId, userUpdateRequest, context)
                        }
                    } else {
                        Toast.makeText(context, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF607D8B), contentColor = Color.White),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

fun sendUpdatedUserToBackend(userId: Int, userUpdateRequest: UserUpdateRequest?, context: Context) {
    RetrofitClient.apiService.updateUser(userId, userUpdateRequest).enqueue(object : Callback<Unit> {
        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
            if (response.isSuccessful) {
                Toast.makeText(context, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed to update profile.", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<Unit>, t: Throwable) {
            Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })
}

private fun Any.enqueue(unitCallback: Callback<Unit>) {

}

@Composable
fun TextFieldWithTitle(title: String, value: String, onValueChange: (String) -> Unit, placeholder: String) {
    Column {
        Text(text = title, fontWeight = FontWeight.SemiBold, color = Color(0xFF444444), fontSize = 20.sp)
        OutlinedTextField(value = value, onValueChange = onValueChange, placeholder = { Text(placeholder) })
    }
}

@Composable
fun ObjectiveCard(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color(0xFF607D8B), shape = RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
    }
}

@Composable
fun RadioButtonWithLabel(selected: Boolean, label: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onClick() }
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = label, modifier = Modifier.padding(start = 8.dp), color = Color(0xFF444444), fontSize = 16.sp)
    }
}
