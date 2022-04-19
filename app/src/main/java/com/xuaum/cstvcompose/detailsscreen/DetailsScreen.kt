package com.xuaum.cstvcompose.detailsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.xuaum.cstvcompose.Player
import com.xuaum.cstvcompose.Side
import com.xuaum.cstvcompose.homescreen.TeamsContainer
import com.xuaum.cstvcompose.ui.theme.CardBackground
import com.xuaum.cstvcompose.ui.theme.Gray
import com.xuaum.cstvcompose.ui.theme.LightGray

@Destination
@Composable
fun DetailsScreen(
    team1Id: Int,
    team2Id: Int,
    matchTime: String,
    league: String,
    navigator: DestinationsNavigator,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            IconButton(
                onClick = { navigator.popBackStack() }
            ) {
                Icon(
                    Icons.Filled.ArrowBack, contentDescription = "Voltar", modifier = Modifier
                        .size(24.dp)
                )
            }
            Text(
                text = league,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                lineHeight = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
            )


        }
        Spacer(Modifier.padding(top = 24.dp))
        TeamsContainer(team1 = "Time $team1Id", team2 = "Time $team2Id")
        Text(
            text = matchTime,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Row(Modifier.fillMaxSize()) {
            PlayerList(modifier = Modifier.fillMaxWidth(0.5f), players = buildList {
                for (i in 1..5) {
                    val name = "Team $team1Id Player $i"
                    add(
                        Player(
                            name = name,
                            nickname = "xx${name}xx"
                        )
                    )
                }
            })
            Spacer(modifier = Modifier.padding(start = 13.dp))

                PlayerList(modifier = Modifier.fillMaxWidth(0.5f), players = buildList {
                    for (j in 1..5) {
                        val name = "Team $team2Id Player $j"
                        add(
                            Player(
                                name = name,
                                nickname = "xx${name}xx"
                            )
                        )
                    }
                })


        }
    }
}

@Composable
fun PlayerList(players: List<Player>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        players.forEach {
            PlayerItem(player = it)
        }
    }
}

@Composable
fun PlayerItem(player: Player) {
    Box(
        modifier = Modifier
            .size(width = 174.dp, height = 58.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp)
                .background(
                    color = CardBackground,
                    shape = RoundedCornerShape(
                        topEnd = 12.dp,
                        bottomEnd = 12.dp
                    )
                )
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 12.dp, bottom = 8.dp),
            verticalAlignment = Alignment.Bottom,

            ) {
            Column(
                modifier = Modifier.size(width = 90.dp, height = Dp.Unspecified),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = player.nickname,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.End,
                    maxLines = 1
                    )
                Text(
                    text = player.name,
                    color = Gray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Box(
                modifier = Modifier
                    .background(color = LightGray, shape = RoundedCornerShape(8.dp))
                    .size(50.dp)
            )
        }
    }
}