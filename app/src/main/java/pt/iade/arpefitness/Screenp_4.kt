package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Screenp_4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenProfilefour()


        }
    }
}

@Composable
fun ScreenProfilefour(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFD9D9D9)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(modifier = Modifier.padding(top = 50.dp),
            text = "My profile",
            fontSize = 18.sp ,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(20.dp))

        LinearProgressIndicator(
            progress = {0.8f},
            modifier = Modifier
                .padding(vertical =16.dp)
                .height(4.dp)
                .padding(start =12.dp, end = 12.dp)
                .fillMaxWidth(),
            color = Color.White
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text (modifier = Modifier.padding(start= 12.dp, end = 12.dp),
            text = "Do you want to perform cardio exercises at the gym?",
            fontSize =30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000000).copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.padding(30.dp))

        LevelCard(
            title = "include cardio in your workouts",
            description = "Cardio exercises will be added before or after workouts",
            onClick = {

            })

        Spacer(modifier = Modifier.height(20.dp))

        LevelCard(
            title = "I don't want cardio exercises",
            description = "Cardio exercises will not be added on training days",
            onClick = {

            }
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {},
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
fun LevelCard(title:String, description:String, onClick : () -> Unit){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(start = 12.dp, end = 12.dp)
        .background(Color(0XFF999999), shape = RoundedCornerShape(8.dp))
        .clickable { onClick() }
        .padding(16.dp) //faz o card ser clicável
    ){

        Text(modifier = Modifier,
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = description,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }


}


@Preview(showBackground = true)
@Composable
fun ScreenProfilefourPreview(){
    ScreenProfilefour()

}