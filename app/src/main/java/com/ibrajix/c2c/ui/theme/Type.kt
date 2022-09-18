package com.ibrajix.c2c.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ibrajix.c2c.R

val PtSans = FontFamily(
    Font(R.font.pt_sans_regular, FontWeight.Normal),
    Font(R.font.pt_sans_bold, FontWeight.Bold)
)

val MyTypography = Typography(

    defaultFontFamily = PtSans,

    h1 = TextStyle(
        fontFamily = PtSans,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),

    h2 = TextStyle(
        fontFamily = PtSans,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp
    ),

    body1 = TextStyle(
        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = PtSans,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
)