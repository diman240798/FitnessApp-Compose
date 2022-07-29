package com.yvkalume.fitnessapp.presentation.screen.main.womenprogram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yvkalume.fitnessapp.R
import com.yvkalume.fitnessapp.presentation.Screens
import com.yvkalume.fitnessapp.presentation.component.program.ProgramItem
import com.yvkalume.fitnessapp.presentation.theme.Typography
import com.yvkalume.fitnessapp.presentation.theme.White


@Composable
fun WomenProgramsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_women_programs_slice),
            contentDescription = "Android",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Программы тренировок для женщин",
            style = Typography.h2,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 20.dp)
        )

        val items = stringArrayResource(R.array.programWomen)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            for ((index, name) in items.withIndex()) {
                item {
                    ProgramItem(name) {
                        navController.navigate(
                            Screens.WebView.createRoute(
                                "file:///android_asset/program/n2s${index + 1}.html"
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
