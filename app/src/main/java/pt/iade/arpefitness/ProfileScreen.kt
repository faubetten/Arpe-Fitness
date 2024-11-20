package pt.iade.arpefitness

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.arpefitness.ui.theme.ArpefitnessTheme

class ProfileScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Profilescreen()

        }
    }
}

@Composable
fun Profilescreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0XFFD9D9D9)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Profile Screen")


    }
}
@Preview(showBackground = true)
@Composable
fun ProfilescreencPreview(){
    Profilescreen()

}