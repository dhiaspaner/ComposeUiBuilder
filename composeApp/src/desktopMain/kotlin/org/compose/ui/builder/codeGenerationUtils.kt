package org.compose.ui.builder

import androidx.compose.ui.graphics.Color


fun Color.toKotlinCode(): String {
    val myColors = mapOf(
        Color.Yellow to "Color.Yellow",
        Color.Red to "Color.Red",
        Color.Blue to "Color.Blue",
        Color.Green to "Color.Green",

        Color.Black to "Color.Black",
        Color.White to "Color.White",

        Color.Transparent to "Color.Transparent",

        Color.Cyan to "Color.Cyan",
        Color.Magenta to "Color.Magenta",
        Color.Gray to "Color.Gray",
        Color.LightGray to "Color.LightGray",
        Color.DarkGray to "Color.DarkGray",

    )
    return myColors.getOrElse(this) {
        val red = (red * 255).toInt()
        val green = (green * 255).toInt()
        val blue = (blue * 255).toInt()
        val alpha = (alpha * 255).toInt()
        return "Color(0xFF${String.format("%02X%02X%02X%02X", alpha, red, green, blue)})"
    }
}