package com.example.faangx.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.faangx.R

val Roboto = FontFamily(
    Font(R.font.robotomedium, FontWeight.Medium),
    Font(R.font.robotoregular, FontWeight.Normal)
)

val Montserrat = FontFamily(
    Font(R.font.montserratregular, FontWeight.Normal)
)

val CenturyGothic = FontFamily(
    Font(R.font.gothicb, FontWeight.Bold),
    Font(R.font.centurygothicregular, FontWeight.Normal)
)

val Typography.header : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = CenturyGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

val Typography.profileBio: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

val Typography.profileText: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

val Typography.montserrat16: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

val Typography.century1: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = CenturyGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

val Typography.saveButton: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = CenturyGothic,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )

val Typography.Gender: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = CenturyGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    )


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)