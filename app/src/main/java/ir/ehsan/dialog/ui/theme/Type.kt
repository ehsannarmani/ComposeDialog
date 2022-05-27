package ir.ehsan.dialog.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.ehsan.dialog.R

// Set of Material typography styles to start with

val yekan = FontFamily(listOf(
    Font(
        resId = R.font.yekan_medium,
        weight = FontWeight.Medium
    ),Font(
        resId = R.font.yekan_regular,
        weight = FontWeight.Normal
    ),
))

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = yekan,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
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