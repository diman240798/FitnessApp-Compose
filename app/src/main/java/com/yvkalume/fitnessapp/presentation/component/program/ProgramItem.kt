package com.yvkalume.fitnessapp.presentation.component.program

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yvkalume.fitnessapp.presentation.theme.Typography
import com.yvkalume.fitnessapp.presentation.theme.White
import com.yvkalume.fitnessapp.presentation.theme.horizontalGradient
import kotlin.random.Random

@Composable
fun ProgramItem(
    programName: String,
    exercisesCount: Int = Random.nextInt(10) + 2,
    timeMinutes: Int = Random.nextInt(30) + 2,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(horizontalGradient, RoundedCornerShape(20.dp), 0.5F)
            .clickable {
                onClick()
            }
    ) {

        Text(
            text = programName,
            style = Typography.h4,
            modifier = Modifier.padding(12.dp, 12.dp, 12.dp)
        )

        Text(
            "$exercisesCount Упражнений | $timeMinutes минут",
            style = Typography.subtitle1,
            modifier = Modifier.padding(12.dp, 8.dp)
        )

        Text(
            "Больше",
            style = Typography.h5,
            modifier = Modifier
                .padding(start = 12.dp, bottom = 8.dp)
                .background(White, RoundedCornerShape(50.dp))
                .padding(12.dp, 8.dp)
        )
    }
}
