package org.compose.ui.builder.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.compose.ui.builder.component.Component
import org.compose.ui.builder.modifierOperation.ModifierOperation

class ColumnLayout() : Layout, Component {

    override var modifier: Modifier = Modifier
    override var onModifierChangeIncrement: Int by mutableStateOf(0)
    override var modifierOperationList: List<ModifierOperation> = emptyList()

    @Composable
    override fun showUi() {
        onModifierChangeIncrement
        Column(
            modifier = modifier
        ) {
            componentList.forEach {
                it.showUi()
            }
        }

    }

    override fun generateCode(): String {
        var contentCode = ""
        componentList.forEach {
            contentCode += "    " + it.generateCode() + "\n"
        }
        return """Column(
            modifier =   ${generateModifier()}
        ) {
            $contentCode
        }
        """.trimIndent()
    }

    override var componentList: List<Component> = emptyList()

}
