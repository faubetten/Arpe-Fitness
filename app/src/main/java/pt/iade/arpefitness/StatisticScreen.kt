import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculator()
        }
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
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Calculadora de IMC", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))


        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Peso (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                ),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedLabelColor = Color(0xFF999999),
                focusedBorderColor = Color(0xFF999999),
                unfocusedBorderColor = Color.Gray),
                )

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Altura (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedLabelColor = Color(0xFF999999),
                focusedBorderColor = Color(0xFF999999),
                unfocusedBorderColor = Color.Gray)
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
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999)
            )
        ) {

            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))


        bmi?.let {
            Text(text = "Seu IMC: ${"%.2f".format(it)}",
                fontSize = 20.sp, modifier = Modifier.padding(top = 16.dp))
            bmiCategory?.let { category ->
                Text(text = "Categoria: $category",
                    fontSize = 18.sp)
            }
        }
    }
}

fun getBMICategory(bmi: Double): String {
    return when {
        bmi < 18.5 -> "Abaixo do peso"
        bmi in 18.5..24.9 -> "Peso normal"
        bmi in 25.0..29.9 -> "Sobrepeso"
        else -> "Obesidade"
    }
}

@Preview(showBackground = true)
@Composable
fun BMIcalculatorPreview(){
    BMICalculator()
}

