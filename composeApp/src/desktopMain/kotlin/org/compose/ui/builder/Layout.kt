package org.compose.ui.builder

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

interface Layout {

    var componentList: List<Component>

    fun addComponent(component: Component) {
        componentList += component
    }

    fun removeComponent(component: Component) {
        componentList -= component
    }

}

class ColumnComponent() : Layout, Component {

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
