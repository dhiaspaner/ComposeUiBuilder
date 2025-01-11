package org.compose.ui.builder.modifierOperation

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

class SizeOperation(val width: Dp, val height: Dp) : ModifierOperation {
    override fun applyOnModifier(modifier: Modifier): Modifier = modifier.size(width, height)

    override fun generateOperationCode(): String
    = ".size(width = ${width.value}, height = ${height.value})"

}