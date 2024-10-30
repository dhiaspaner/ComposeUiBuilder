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

    override fun generateKotlinCode(): String {
        var contentCode = ""
        componentList.forEach {
            contentCode += "    " + it.generateKotlinCode() + "\n"
        }
        return """Column(
            modifier = Modifier${generateModifier()}
        ) {
            $contentCode
        }
        """.trimIndent()
    }

    override var componentList: List<Component> = emptyList()

}

//needs to create a component on separate file with keeping in count the nested layouts/components
class ComponentFactory {



}