package org.compose.ui.builder.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.compose.ui.builder.component.Component
import org.compose.ui.builder.modifierOperation.ModifierOperation

class BoxLayout() : Layout, Component {

    override var componentList: List<Component> = emptyList()
    override var modifier: Modifier = Modifier
    override var onModifierChangeIncrement: Int by mutableIntStateOf(0)
    override var modifierOperationList: List<ModifierOperation> = emptyList()


    @Composable
    override fun showUi() {
        Box(
            modifier = modifier,
        ) {
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
        
        }
    """.trimIndent()
    }

}