package com.example.faangx.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val BLUE = Color(0xff150099)
val PURPLE = Color(0xff6E008A)
val PUPRLEH = Color(0xff760094)
val PURPLEA = Color(147, 45, 176, 20)
val PINK = Color(0xffFCD7FF)
val LIGHTERPINK = Color(0xffF8F2FA)
val GRAYLINE = Color(0xff857370)
val GRAYTXT = Color(0xff7F7573)
val CHATGRAY = Color(0xff7B7579)
val BLACKF = Color(0xff201A19)
val BLACK = Color(0xff000000)
val RED = Color(0xffD70D32)

val Colors.bgColor1 : Color
    @Composable
    get() = BLUE

val Colors.bgColor2 : Color
    @Composable
    get() = PURPLE

val Colors.appTheme : Color
    @Composable
    get() = PUPRLEH

val Colors.purpleTransparent: Color
    @Composable
    get() = PURPLEA

val Colors.loginBG: Color
    @Composable
    get() = if(isLight) LIGHTERPINK else BLACK

val Colors.chatBox: Color
    @Composable
    get() = PINK

val Colors.placeholderText: Color
    @Composable
    get() = BLACKF

val Colors.text: Color
    @Composable
    get() = if(isLight) BLACK else Color(0xfffafafa)

val Colors.editTextOutline: Color
    @Composable
    get() = GRAYLINE

val Colors.grayText: Color
    @Composable
    get() = GRAYTXT

val Colors.redStar: Color
    @Composable
    get() = if(isLight) RED else PINK

val Colors.homeChatColor: Color
    @Composable
    get() = Color(0xff7B7579)

val Colors.homeTimeColor: Color
    @Composable
    get() = Color(0xff958F93)

val Colors.bgColor: Color
    @Composable
    get() = if(isLight)Color.White else BLACK