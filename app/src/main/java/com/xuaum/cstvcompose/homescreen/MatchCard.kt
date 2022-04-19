package com.xuaum.cstvcompose.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xuaum.cstvcompose.CSMatch
import com.xuaum.cstvcompose.ui.theme.*

@Composable
fun MatchCard(csMatch: CSMatch, onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = CardBackground, shape = RoundedCornerShape(16.dp))
            .clickable {
                onClick()
            },
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(
                text = if (csMatch.live) "AGORA" else csMatch.matchTime,
                textAlign = TextAlign.Center,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = if (csMatch.live) Red else DarkGray,
                        shape = RoundedCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
                    )
                    .padding(8.dp)
            )

        }
        TeamsContainer(
            team1 = csMatch.team1,
            team2 = csMatch.team2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 70.dp, vertical = 18.5.dp)
        )
        Divider(thickness = 1.dp, color = Line)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                Modifier
                    .size(16.dp)
                    .background(color = LightGray, shape = CircleShape)
            )
            Text(text = csMatch.leaguePlusSeries, color = Color.White, fontSize = 8.sp)
        }

    }
}

@Composable
fun Team(name: String, imageUrl: String) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .size(60.dp)
                .background(color = LightGray, shape = CircleShape)
        )
        Text(text = name, color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun TeamsContainer(team1: String, team2: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        Team(name = team1, imageUrl = "")
        Text(
            text = "vs",
            color = Gray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Team(name = team2, imageUrl = "")
    }
}