package org.compose.ui.builder.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.compose.ui.builder.modifierOperation.ModifierOperation

interface  Component {

    var modifier: Modifier
    var onModifierChangeIncrement: Int
    var modifierOperationList: List<ModifierOperation>

    fun onChangeModifier(operation: ModifierOperation)  {
        modifierOperationList += operation
        modifier = operation.applyOnModifier(modifier)
        onModifierChangeIncrement ++
    }

    fun generateModifier() : String {
        var modifierOperationListString = "Modifier\n"
        modifierOperationList.forEach { op ->
            modifierOperationListString += op.generateOperationCode() + "\n"
        }
        return modifierOperationListString.also {
            println("component modifier string : $it")
        }
    }

    @Composable
    fun showUi()

    fun generateKotlinCode(): String

}



