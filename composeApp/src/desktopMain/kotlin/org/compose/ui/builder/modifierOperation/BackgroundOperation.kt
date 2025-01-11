package org.compose.ui.builder.modifierOperation

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import org.compose.ui.builder.toKotlinCode

class BackgroundOperation(val color: Color, val shape: Shape =  RectangleShape) : ModifierOperation {

    override fun applyOnModifier(modifier: Modifier) = modifier
        .background(color = color , shape = shape)

    override fun generateOperationCode() = ".background(color = ${color.toKotlinCode()},shape = $shape)"

}