package org.compose.ui.builder.layout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.compose.dnd.DragAndDropState
import com.mohamedrejeb.compose.dnd.drop.dropTarget
import org.compose.ui.builder.component.Component
import org.compose.ui.builder.modifierOperation.FillMaxHeightOperation
import org.compose.ui.builder.modifierOperation.FillMaxWidthOperation
import org.compose.ui.builder.modifierOperation.ModifierOperation
import org.compose.ui.builder.panels.PaletteElements

class BoxLayout() : Layout {

    override var componentList: List<Component> = emptyList()
    override var modifier: Modifier = Modifier
    override var onModifierChangeIncrement: Int by mutableIntStateOf(0)
    override var modifierOperationList: List<ModifierOperation> = emptyList()
    override var isHovered by mutableStateOf(false)
    override var isSelected by mutableStateOf(false)
    override var onClick = {}

    init {
        modifier = modifier
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        isHovered = when (event.type) {
                            PointerEventType.Enter, PointerEventType.Move -> true
                            else -> false
                        }
                    }

                }
            }

        val fillMaxHeightOperation = FillMaxHeightOperation()
        val fillMaxWidthOperation = FillMaxWidthOperation()
        onAddModifierOperation(fillMaxHeightOperation)
        onAddModifierOperation(fillMaxWidthOperation)
    }
    @Composable
    override fun showUi() {
        Box(
            modifier = modifier
                .border(
                    width = 10.dp,
                    color = if (isHovered) Color.Black else Color.Transparent,
                ),
        ) {
            onModifierChangeIncrement++
            componentList.forEach { component ->
                component.showUi()
            }
        }
    }

    override fun generateKotlinCode(): String {
        var componentListCode = ""
        componentList.forEach {
            componentListCode += "${it.generateKotlinCode()}\n"
        }
        return """
        Box(
           modifier = ${generateModifier()}
        ) {
                $componentListCode
        }
    """.trimIndent()
    }

}