package com.xuaum.cstvcompose

data class CSMatch(
    val matchTime: String = "",
    val live: Boolean = false,
    val team1: String,
    val team1Img: String = "",
    val team2: String,
    val team2Img: String = "",
    val leaguePlusSeries: String = "League + series"
)
