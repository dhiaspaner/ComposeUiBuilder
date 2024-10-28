package org.compose.ui.builder.modifierOperation

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

sealed interface ModifierOperation {

    fun applyOnModifier(modifier: Modifier = Modifier) : Modifier

    fun generateOperationCode() : String
}



