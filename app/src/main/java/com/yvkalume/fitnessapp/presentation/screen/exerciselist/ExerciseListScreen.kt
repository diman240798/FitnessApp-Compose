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
import androidx.compose.ui.graphics.Brush
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

private val items = arrayListOf(
    R.array.subsection_arr_1,
    R.array.subsection_arr_2,
    R.array.subsection_arr_3,
    R.array.subsection_arr_4,
    R.array.subsection_arr_5,
    R.array.subsection_arr_6,
    R.array.subsection_arr_7
)

@Composable
fun ExercisesListScreen(navController: NavHostController, type: Exercises) {
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
                    modifier = Modifier
                        .padding(16.dp, 8.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )

                Text(
                    text = "Упражнения",
                    style = Typography.h2,
                    color = Color.White
                )
            }

            val exercieses = stringArrayResource(items[type.ordinal])

            val viewFile = "file/n1s1"

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp, 24.dp, 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                for (name in exercieses) {
                    item {
                        ExerciseListItem(name) {
                            navController.navigate(
                                Screens.WebView.createRoute(
                                    "file:///android_asset/" + viewFile + ".html"
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
