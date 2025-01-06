package pt.iade.arpefitness

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Screenp3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screenp_3(){}
        }
    }
}

@Composable
fun  Screenp_3(onNavigateToNextScreen: () -> Unit) {

    var level by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "My profile ",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(15.dp))

        LinearProgressIndicator(
            progress = 0.6f,
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(4.dp),
            color = Color.White,
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            modifier = Modifier.padding(start = 24.dp, end = 12.dp),
            text = "What is your experience practicing bodybuilding?",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000000).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        ObjetiveCard2(
            title = "Beginner",
            description = "Starting practice or less than 6 months experiences",
            onClick = {level = "Beginner"

                val intent = Intent(context, Screenp4::class.java)
                intent.putExtra("level", level)
                context.startActivity(intent)}
        )

        Spacer(modifier = Modifier.height(13.dp))

        ObjetiveCard2(
            title = "Intermediary",
            description = "Have been practicing bodybuilding for more than 6 months and less than 2 years",
            onClick = {level = "Intermediary"

                val intent = Intent(context, Screenp4::class.java)
                intent.putExtra("level", level)
                context.startActivity(intent)}
        )

        Spacer(modifier = Modifier.height(13.dp))

        ObjetiveCard2(
            title = "Advanced",
            description = "Have been practicing bodybuilding for more than 2 years consistently",
            onClick = {level = "Advanced"
                val intent = Intent(context, Screenp4::class.java)
                intent.putExtra("level", level)
                context.startActivity(intent)}
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(onClick = {onNavigateToNextScreen},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(horizontal = 90.dp)
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
        ) {
            Text( text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold)
        }
    }
}


@Composable
fun ObjetiveCard2(title: String, description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp)
            .fillMaxWidth()
            .background(Color(0XFF999999), shape = RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = description,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}
@Preview(showBackground = true)
@Composable
fun  Screenp_3Preview() {
    Screenp_3(){}
}