package com.czech.breakingbad.android.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.czech.breakingbad.android.R

private val Roboto = FontFamily(
    Font(R.font.roboto_thin, FontWeight.W100),
    Font(R.font.roboto_light, FontWeight.W300),
    Font(R.font.roboto_regular, FontWeight.W400),
    Font(R.font.roboto_medium, FontWeight.W500),
    Font(R.font.roboto_bold, FontWeight.W700),
    Font(R.font.roboto_black, FontWeight.W900)
)

val RobotoTypography = Typography(
    h1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
    ),
    h3 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.W700)),
        fontSize = 18.sp,
    ),
    button = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W700,
        fontSize = 18.sp
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp
    )

)