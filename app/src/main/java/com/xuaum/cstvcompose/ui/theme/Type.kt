package com.xuaum.cstvcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.xuaum.cstvcompose.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.roboto_regular, FontWeight.Normal),
            Font(R.font.roboto_medium, FontWeight.Medium),
            Font(R.font.roboto_bold, FontWeight.Bold)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)