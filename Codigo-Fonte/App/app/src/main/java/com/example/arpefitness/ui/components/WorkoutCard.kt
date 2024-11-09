package com.example.arpefitness.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.arpefitness.models.Exercise
import com.example.arpefitness.models.Workout
import java.net.URI
import com.example.arpefitness.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable

fun WorkoutCard(
    workout: Workout,
    modifier: Modifier = Modifier
) {
    Card(
        //TODO: Add onClick

    ) {
        Box(
            modifier = Modifier.width(150.dp).height(100.dp),
        ) {
            Image(
                painter = workout.image,
                contentDescription = workout.name,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillHeight
            )

            Text(
                //TODO: import font from resources
                text = workout.name,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp),

                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            )

        }
    }



}

@Preview (showBackground = true)
@Composable
fun WorkoutCardPreview() {
    WorkoutCard(
        workout = Workout(
            id = 0,
            name = "Custom Workout",
            description = "Description",
            duration = 30,
            calories = 300,
            image = painterResource(R.drawable.custom_workout),
            exercises = listOf(
                Exercise(
                    id = 0,
                    name = "Exercise 1",
                    description = "Description",
                    duration = 10,
                    calories = 100,
                    image = null
                ),
                Exercise(
                    id = 1,
                    name = "Exercise 2",
                    description = "Description",
                    duration = 10,
                    calories = 100,
                    image = null
                ),
                Exercise(
                    id = 2,
                    name = "Exercise 3",
                    description = "Description",
                    duration = 10,
                    calories = 100,
                    image = null
                )
            )
        )
    )
}