package pt.iade.arpefitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class StatisticScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StatisticScreen()
        }
    }
}

@Composable
fun StatisticsScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0XFFD9D9D9)),
        contentAlignment = Alignment.Center
    ) {
        Text("Tela Estatística")
    }
}

@Preview(showBackground = true)
@Composable
fun StatisticScreenPreview() {
    StatisticsScreen()
}