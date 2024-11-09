package com.example.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arpefitness.ui.theme.ArpeFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArpeFitnessTheme {


            }
        }
    }
}




//TODO add bottom bar and Workout cards
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(

                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Gray),
                    title = {

                        Box(
                            modifier = Modifier.fillMaxWidth().padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "Workouts",
                                fontSize = 20.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },

                    navigationIcon = {

                        IconButton(

                            onClick = {  }
                        ) {
                            Icon(
                                modifier = Modifier.scale(1.5f),

                                painter = painterResource(R.drawable.navigador),
                                contentDescription = "Menu"
                            )



                        }


                    },

                    actions = {

                        IconButton(

                            onClick = { }
                        ) {
                            Icon(
                                modifier = Modifier.scale(1.5f),

                                painter = painterResource(R.drawable.history),
                                contentDescription = "Search"
                            )
                        }
                    }


                )
            }





        ) { innerPadding ->
            Text(
                text = "Hello World!",
                modifier = Modifier.padding(innerPadding)
            )




        }
}





@Preview (showBackground = true)
@Composable
fun MainViewPreview() {
    ArpeFitnessTheme {
        MainView()
    }
}