package pt.iade.arpefitness

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.models.UserData
import java.time.LocalDate
import java.util.*

class Screenp1 : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                ProfileOne(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileOne(modifier: Modifier = Modifier) {
    var gender by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf<LocalDate?>(null) }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

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
        return dob != null && weight.isNotEmpty() && height.isNotEmpty()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
        ) {

            Text(
                text = "What are your body metrics?",
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF444444),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Gender Selection
            Text(
                text = "Gender",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF444444),
                fontSize = 20.sp
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                RadioButtonWithLabel(
                    selected = (gender == "M"),
                    label = "Male",
                    onClick = { gender = "M" }
                )
                RadioButtonWithLabel(
                    selected = (gender == "F"),
                    label = "Female",
                    onClick = { gender = "F" }
                )
            }

            // Date of Birth
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Date of Birth",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF444444),
                fontSize = 20.sp
            )
            Button(
                onClick = { datePickerDialog.show() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF444444)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = dob?.toString() ?: "Select your date of birth",
                    fontSize = 16.sp,
                    color = if (dob != null) Color(0xFF444444) else Color.Gray
                )
            }

            // Weight
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Weight (kg)",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF444444),
                fontSize = 20.sp
            )
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text("Enter your weight") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF607D8B),
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            // Height
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Height (m)",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF444444),
                fontSize = 20.sp
            )
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text("Enter your height") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF607D8B),
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )
        }

        val context = LocalContext.current

        val userData = UserData(
            id = 0,
            name = "",
            email = "",
            password = "",
            gender = "",
            dob = null,
            weight = 0,
            height = 0,
            objective = "",
            level = ""
        )

        Button(
            onClick = {
                if (isValidForm()) {

                    val updatedUserData = userData.copy(
                        gender = gender,
                        dob = dob,
                        weight = weight.toIntOrNull() ?: 0,
                        height = height.toIntOrNull() ?: 0
                    )
                    val intent = Intent(context, Screenp2::class.java)
                    intent.putExtra("UserData", updatedUserData)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF607D8B),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(horizontal = 90.dp)
                .fillMaxWidth()
                .height(60.dp)
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
fun RadioButtonWithLabel(selected: Boolean, label: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        )
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF607D8B),
                unselectedColor = Color.Gray
            )
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp),
            color = Color(0xFF444444),
            fontSize = 16.sp
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ProfileOnePreview() {
    ProfileOne()
}
