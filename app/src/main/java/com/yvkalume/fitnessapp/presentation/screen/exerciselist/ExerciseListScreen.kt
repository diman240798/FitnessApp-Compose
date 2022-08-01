package com.yvkalume.fitnessapp.presentation.screen.exerciselist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yvkalume.fitnessapp.R
import com.yvkalume.fitnessapp.data.Exercises
import com.yvkalume.fitnessapp.presentation.Screens
import com.yvkalume.fitnessapp.presentation.component.exerciselist.ExerciseListItem
import com.yvkalume.fitnessapp.presentation.theme.Typography
import com.yvkalume.fitnessapp.presentation.theme.White
import com.yvkalume.fitnessapp.presentation.theme.horizontalGradient
import kotlin.random.Random

@Composable
fun ExercisesListScreen(navController: NavHostController, type: Exercises) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = horizontalGradient
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
                        color = White,
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
                    modifier = Modifier
                        .padding(16.dp, 8.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )

                Text(
                    text = "Упражнения",
                    style = Typography.h2,
                    color = White
                )
            }

            val exercieses = stringArrayResource(type.exercisesList)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp, 24.dp, 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                for ((index, name) in exercieses.withIndex()) {
                    item {
                        ExerciseListItem(name, Random.nextInt(98) + 2) {
                            navController.navigate(
                                Screens.WebView.createRoute(
                                    "file:///android_asset/file/n${type.ordinal + 1}s${index + 1}.html"
                                )
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
