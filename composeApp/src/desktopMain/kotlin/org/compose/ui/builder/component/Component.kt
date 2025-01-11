package org.compose.ui.builder.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.compose.ui.builder.modifierOperation.ModifierOperation
import java.util.UUID

interface  Component {

    var isHovered: Boolean

    var isSelected: Boolean

    var modifier: Modifier

    var onClick: () -> Unit get() =  {}
        set(value) {}

    var onModifierChangeIncrement: Int
    var modifierOperationList: List<ModifierOperation>

    fun onAddModifierOperation(operation: ModifierOperation)  {
        modifierOperationList += operation
        modifier = operation.applyOnModifier(modifier)
        onModifierChangeIncrement ++
    }

    fun generateModifier() : String {
        var modifierOperationListString = "Modifier\n"
        modifierOperationList.forEach { op ->
            modifierOperationListString += op.generateOperationCode() + "\n"
        }
        return modifierOperationListString
    }

    @Composable
    fun showUi()

    fun generateKotlinCode(): String

}



