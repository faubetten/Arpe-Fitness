package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

class StatisticsScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatisticsContent()
        }
    }
}

@Composable
fun StatisticsContent() {
    var selectedDate by remember { mutableStateOf(getTodayDate()) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Cor de fundo
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Horizontal calendar
            item {
                HorizontalCalendar(selectedDate = selectedDate, onDateSelected = { selectedDate = it })
            }

            // Statistics section
            item {
                StatisticsInfoSection(
                    caloriesBurned = 258.03,
                    bmi = 22.72,
                    weight = 72.0,
                    trainingTime = "12:28"
                )
            }

            // BMI Calculator section
            item {
                BMICalculator()
            }
        }
    }
}

@Composable
fun HorizontalCalendar(
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {
    val calendar = Calendar.getInstance()
    val days = mutableListOf<Pair<String, String>>()

    // Generate 15 days (7 previous, today, and 7 future)
    for (i in -7..7) {
        calendar.add(Calendar.DATE, i)
        val dayOfWeek = SimpleDateFormat("EEE", Locale.getDefault()).format(calendar.time).uppercase()
        val dayOfMonth = SimpleDateFormat("dd", Locale.getDefault()).format(calendar.time)
        days.add(Pair(dayOfWeek, dayOfMonth))
        calendar.add(Calendar.DATE, -i) // Reset calendar
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(days.size) { index ->
            val (dayOfWeek, dayOfMonth) = days[index]
            val isSelected = dayOfMonth == selectedDate
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) Color(0xFF607D8B) else Color.White)
                    .clickable { onDateSelected(dayOfMonth) },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = dayOfWeek,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.White else Color.Black
                    )
                    Text(
                        text = dayOfMonth,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.White else Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun StatisticsInfoSection(
    caloriesBurned: Double,
    bmi: Double,
    weight: Double,
    trainingTime: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "STATISTICS",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF607D8B),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        StatisticsRow(label = "CALORIES BURNED", value = "${String.format("%.2f", caloriesBurned)} KCAL")
        StatisticsRow(label = "BMI", value = String.format("%.2f", bmi))
        StatisticsRow(label = "CURRENT WEIGHT", value = "${String.format("%.1f", weight)} KG")

        Spacer(modifier = Modifier.height(16.dp))

        // Training time
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFCFD8DC), shape = RoundedCornerShape(12.dp))
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = "TRAINING TIME",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = trainingTime,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun StatisticsRow(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Text(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun BMICalculator() {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var bmi by remember { mutableStateOf<Double?>(null) }
    var bmiCategory by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFCFD8DC), RoundedCornerShape(12.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "BMI CALCULATOR",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF607D8B),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF607D8B),
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Height (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF607D8B),
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val weightValue = weight.toDoubleOrNull()
                val heightValue = height.toDoubleOrNull()
                if (weightValue != null && heightValue != null && heightValue > 0) {
                    bmi = weightValue / (heightValue * heightValue)
                    bmiCategory = getBMICategory(bmi!!)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF607D8B))
        ) {
            Text("Calculate", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        bmi?.let {
            Text(
                text = "Your BMI: ${"%.2f".format(it)}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            bmiCategory?.let { category ->
                Text(text = "Category: $category", fontSize = 14.sp)
            }
        }
    }
}

fun getBMICategory(bmi: Double): String {
    return when {
        bmi < 18.5 -> "Underweight"
        bmi in 18.5..24.9 -> "Normal weight"
        bmi in 25.0..29.9 -> "Overweight"
        else -> "Obesity"
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStatisticsContent() {
    StatisticsContent()
}

fun getTodayDate(): String {
    return SimpleDateFormat("dd", Locale.getDefault()).format(Date())
}
