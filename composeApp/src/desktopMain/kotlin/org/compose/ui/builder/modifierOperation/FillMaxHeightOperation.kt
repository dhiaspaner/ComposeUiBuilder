package org.compose.ui.builder.modifierOperation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.Modifier

class FillMaxHeightOperation(val fraction: Float = 1f) : ModifierOperation {
    override fun applyOnModifier(modifier: Modifier): Modifier =
        modifier.fillMaxHeight(fraction = fraction)

    override fun generateOperationCode(): String =
        if (fraction == 1f) ".fillMaxHeight()"
        else ".fillMaxHeight(fraction = ${fraction})"


}