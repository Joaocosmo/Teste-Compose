package com.xuaum.cstvcompose.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.xuaum.cstvcompose.CSMatch
import com.xuaum.cstvcompose.destinations.DetailsScreenDestination

@Destination(start = true)
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Partidas",
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            items(60) { index ->

                val team1 = index * 2
                val team2 = index * 2 + 1
                val csMatch = if (index <= 10) {
                    CSMatch(
                        live = true,
                        team1 = "Time $team1",
                        team2 = "Time $team2",
                    )
                } else {
                    val matchTime = "Hoje, ${index + 20}:${index + 10}"
                    CSMatch(
                        matchTime = matchTime,
                        team1 = "Time $team1",
                        team2 = "Time $team2",
                    )
                }

                MatchCard(
                    csMatch,
                    onClick = {
                        navigator.navigate(
                            DetailsScreenDestination(
                                team1,
                                team2,
                                if (csMatch.live) "AGORA" else csMatch.matchTime,
                                csMatch.leaguePlusSeries
                            )
                        )
                    }
                )
            }
        }
    }
}

