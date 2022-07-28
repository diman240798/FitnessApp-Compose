package com.yvkalume.fitnessapp.presentation.component.exercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yvkalume.fitnessapp.R
import com.yvkalume.fitnessapp.data.Exercises
import com.yvkalume.fitnessapp.presentation.theme.Typography

@Composable
fun ExerciseItem(data: Exercises, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White, RoundedCornerShape(40.dp))
            .clickable(onClick = {
                onClick()
            })
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
fun ExerciseItemPreview() {
    ExerciseItem(Exercises.ABS)
}
