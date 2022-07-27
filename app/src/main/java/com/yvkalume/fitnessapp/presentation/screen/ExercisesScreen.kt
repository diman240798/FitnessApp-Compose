package com.yvkalume.fitnessapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yvkalume.fitnessapp.R
import com.yvkalume.fitnessapp.data.Exercises
import com.yvkalume.fitnessapp.presentation.theme.Typography


@Composable
fun ExercisesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_exercises_slice),
            contentDescription = "Android",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Упражнения",
            style = Typography.h2,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 20.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF92A3FD),
                                Color(0xFF9DCEFF)
                            )
                        ),
                        shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)
                    )
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(0.dp, 12.dp)
                        .width(50.dp)
                        .height(5.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(40.dp)
                        )
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 16.dp, 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Exercises.values().forEach { data ->
                        item {
                            ExerciseItem(data)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExerciseItem(data: Exercises) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White, RoundedCornerShape(40.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(12.dp, 0.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = data.imageRes),
                contentDescription = "Android",
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Text(
                text = stringResource(id = data.nameRes),
                style = Typography.body1,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(12.dp, 0.dp)
            )
        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_next),
            contentDescription = "Android",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(12.dp, 0.dp)
        )
    }
}

@Preview
@Composable
@ExperimentalPagerApi
fun ExercisesScreenPreview() {
    ExercisesScreen()
}
