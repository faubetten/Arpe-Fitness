package pt.iade.arpefitness


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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Screenp_3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenProfilethree()




        }
    }
}



@Composable
fun ScreenProfilethree() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFD9D9D9)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Text( modifier = Modifier.padding(top = 50.dp),
            text = "My profile ",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(15.dp))

        LinearProgressIndicator(
            progress = {0.6f},
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(4.dp),
            color = Color.White,
        )
        Spacer (modifier = Modifier.padding(5.dp))

        Text(modifier = Modifier.padding(start= 24.dp, end = 12.dp),
            text = "What is your experience practicing bodybuilding?",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000000).copy(alpha = 0.6f),// Copy alpha is used para colocar a opacidade
        )

        Spacer (modifier = Modifier.height(30.dp))

        ObjetiveCard(
            title = "Beginner",
            description = "Starting practice or less than 6 months experiences",
            onClick = {

            }

        )

        Spacer (modifier = Modifier.height(13.dp))


        ObjetiveCard(
            title = "Intermediary",
            description = "Have been practicing bodybuilding for more than 6 months and less than 2 years",
            onClick = {

            }

        )

        Spacer (modifier = Modifier.height(13.dp))

        ObjetiveCard(
            title = "Advanced",
            description = "Have been practicing bodybuilding for more than 2 years consistently",
            onClick = {

            }
        )

        Spacer (modifier = Modifier.height(60.dp))

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF999999),
                contentColor = Color.White

            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(horizontal = 90.dp) // Padding externo ao botão
                .fillMaxWidth() // Deixa o botão com largura máxima dentro dos limites de padding
                .height(60.dp) // Define a altura do botão
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),


            ){
            Text( text = "Next",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )



        }






    }





}

@Composable
fun ObjetiveCard (title:String, description:String,onClick: () -> Unit){
    Column(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp )
            .fillMaxWidth()
            .background(Color(0XFF999999), shape = RoundedCornerShape(8.dp))
            .clickable { onClick() } //faz o card ser clicável
            .padding(16.dp)

    ) {
        Text(modifier = Modifier,
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = description,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black)
    }
}

fun onClick() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun ScreenProfilethreePreview(){
    ScreenProfilethree()
}



