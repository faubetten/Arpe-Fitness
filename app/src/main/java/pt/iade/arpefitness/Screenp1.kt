package pt.iade.arpefitness

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

class Screenp1 : ComponentActivity() {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileOne(modifier: Modifier = Modifier) {
    var gender by remember { mutableStateOf("M") }
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
            // Formata a data por "ano/Mes/Dia"
            dob = "$selectedYear/${(selectedMonth + 1).toString().padStart(2, '0')}/" +
                    selectedDay.toString().padStart(2, '0')
        },
        year,
        month,
        day
    )

    fun isValidForm(): Boolean {
        return dob.isNotEmpty() && weight.isNotEmpty() && height.isNotEmpty()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9)) // Background color
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Title
        Text(
            modifier = Modifier.padding(start = 24.dp, end = 12.dp),
            text = "What are your body metrics?",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000000).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Gender Selection (Radio Buttons)
        Text(
            text = "Sex",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 22.sp
        )
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
        Text(
            text = "Date of Birth",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 22.sp
        )

        Button(
            onClick = { datePickerDialog.show() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(8.dp) // Rounded corners
        ) {
            Text(
                text = if (dob.isNotEmpty()) dob else "Select your date of birth",
                fontSize = 16.sp,
                color = if (dob.isNotEmpty()) Color.Black else Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Weight
        Text(
            text = "Weight",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 22.sp
        )
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("Enter your weight") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF999999),
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Black,
                containerColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Height
        Text(
            text = "Height",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 22.sp
        )
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("Enter your height") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF999999),
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Black,
                containerColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(150.dp))

        val context = LocalContext.current

        Button(
            onClick = {

                // Criação do Intent para navegar para a próxima activity
                val intent = Intent(context, Screenp2::class.java)

                // Passando os dados para a próxima Activity
                intent.putExtra("gender", gender)
                intent.putExtra("dob", dob)
                intent.putExtra("weight", weight)
                intent.putExtra("height", height)

                // Iniciando a próxima Activity
                context.startActivity(intent)
             },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White
            )
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
            onClick = onClick
        )
        Text(text = label, modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Screenp1Preview() {
    ProfileOne()
}
