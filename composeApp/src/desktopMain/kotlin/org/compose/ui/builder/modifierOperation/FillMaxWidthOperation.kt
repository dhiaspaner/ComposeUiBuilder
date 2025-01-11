package org.compose.ui.builder.modifierOperation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier

class FillMaxWidthOperation(var fraction: Float = 1f) : ModifierOperation {
    override fun applyOnModifier(modifier: Modifier): Modifier =
        modifier.fillMaxWidth(fraction = fraction)


    override fun generateOperationCode(): String =
        if (fraction == 1f) ".fillMaxWidth()"
        else ".fillMaxWidth(fraction = $fraction)"

}