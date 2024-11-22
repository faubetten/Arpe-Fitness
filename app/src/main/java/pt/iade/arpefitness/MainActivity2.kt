package pt.iade.arpefitness

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.arpefitness.ui.theme.ArpefitnessTheme
import java.util.*
import androidx.compose.ui.platform.LocalContext

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BodyMetricsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

            }
        }
    }
}

@Composable
fun BodyMetricsScreen(modifier: Modifier = Modifier) {
    var gender by remember { mutableStateOf("M") } // Default to Male
    var dob by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, selectedYear, selectedMonth, selectedDay ->
            dob = "${selectedDay.toString().padStart(2, '0')}/" +
                    "${(selectedMonth + 1).toString().padStart(2, '0')}/$selectedYear"
        },
        year,
        month,
        day
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Section
        Column {
            Text(
                text = "What are your body metrics?",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Gender Selection (Radio Buttons)
            Text(text = "Sex", style = MaterialTheme.typography.bodyLarge)
            Row(Modifier.fillMaxWidth()) {
                RadioButtonWithLabel(
                    selected = (gender == "M"),
                    label = "Male",
                    onClick = { gender = "M" }
                )
                Spacer(modifier = Modifier.width(16.dp))
                RadioButtonWithLabel(
                    selected = (gender == "F"),
                    label = "Female",
                    onClick = { gender = "F" }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Date of Birth
            Text(text = "Date of birth", style = MaterialTheme.typography.bodyLarge)
            OutlinedTextField(
                value = dob,
                onValueChange = { dob = it }, // Let the dialog update this
                readOnly = true, // Prevent manual input
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Select your date of birth") },
                trailingIcon = {
                    IconButton(onClick = { datePickerDialog.show() }) {
                       // Icon(
                         //   imageVector = Icons.Default.CalendarToday,
                        // contentDescription = "Select date"
                        //)
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Weight
            Text(text = "Weight", style = MaterialTheme.typography.bodyLarge)
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text("Enter your weight") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Height
            Text(text = "Height", style = MaterialTheme.typography.bodyLarge)
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = { Text("Enter your height") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Bottom Section (Button)
        Button(
            onClick = { /* Handle next click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Next")
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
            onClick = onClick
        )
        Text(text = label, modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BodyMetricsScreenPreview() {
        BodyMetricsScreen()
}
