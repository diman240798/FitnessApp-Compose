package com.yvkalume.fitnessapp.presentation.screen.exerciselist

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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yvkalume.fitnessapp.R
import com.yvkalume.fitnessapp.presentation.component.exerciselist.ExerciseListItem
import com.yvkalume.fitnessapp.presentation.theme.Typography

@Composable
fun ExercisesListScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF92A3FD),
                        Color(0xFF9DCEFF)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 12.dp)
                    .width(50.dp)
                    .height(5.dp)
                    .alpha(0.5F)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(40.dp)
                    )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    modifier = Modifier.padding(16.dp, 8.dp)
                )

                Text(
                    text = "Упражнения",
                    style = Typography.h2,
                    color = Color.White
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, 24.dp, 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                for (i in 0 until 3) {
                    item {
                        ExerciseListItem()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
@ExperimentalPagerApi
fun ExercisesListScreenPreview() {
    ExercisesListScreen()
}
