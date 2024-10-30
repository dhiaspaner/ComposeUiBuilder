package org.compose.ui.builder.modifierOperation

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class BoxAlignmentOperation(
    val alignment: Alignment,
    val boxScope: BoxScope
) : ModifierOperation {

    override fun applyOnModifier(modifier: Modifier): Modifier = with(boxScope) {
        modifier.align(alignment)
    }


    override fun generateOperationCode(): String = ".alignment($alignment)"
}