package com.yvkalume.fitnessapp.presentation.component.exerciselist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yvkalume.fitnessapp.presentation.theme.Typography
import com.yvkalume.fitnessapp.presentation.theme.activeProgress
import com.yvkalume.fitnessapp.presentation.theme.backgroundProgress

@Composable
fun ExerciseListItem(exerciseName: String, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = exerciseName,
            style = Typography.body1,
            modifier = Modifier.padding(16.dp, 8.dp, 16.dp)
        )

        Text(
            text = "Сложность: 33%",
            style = Typography.caption,
            modifier = Modifier.padding(16.dp, 0.dp)
        )

        LinearProgressIndicator(
            progress = 0.5f,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent, shape = RoundedCornerShape(99.dp))
                .height(15.dp)
                .padding(16.dp, 4.dp),
            color = activeProgress,
            backgroundColor = backgroundProgress
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}
