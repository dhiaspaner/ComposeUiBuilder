package org.compose.ui.builder

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

sealed interface ModifierOperation {

    fun applyOnModifier(modifier: Modifier = Modifier) : Modifier

    fun generateOperationCode() : String
}

class BackgroundOperation(val color: Color, val shape: Shape =  RectangleShape) : ModifierOperation {

    val myColors = mapOf(Color.Cyan to "Color.Cyan")

    fun colorToHex(color: Color): String {
        val red = (color.red * 255).toInt()
        val green = (color.green * 255).toInt()
        val blue = (color.blue * 255).toInt()
        val alpha = (color.alpha * 255).toInt()
        return String.format("%02X%02X%02X%02X", alpha, red, green, blue)
    }

    override fun applyOnModifier(modifier: Modifier) = modifier.background(color = color , shape = shape)

    override fun generateOperationCode() = ".background(color = ${myColors.getOrElse(color) {
        "Color(0xFF${colorToHex(color)})"
    }},shape = $shape)"

}

