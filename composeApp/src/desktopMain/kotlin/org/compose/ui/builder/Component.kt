package org.compose.ui.builder

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

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
        var modifierOperationListString = ""
        modifierOperationList.forEach { op ->
            modifierOperationListString += op.generateOperationCode() + "\n"
        }
        return modifierOperationListString.also {
            println("component modifier string : $it")
        }
    }

    @Composable
    fun showUi()

    fun generateCode(): String

}

class TextComponent(private val text: String) : Component {

    override var modifier: Modifier = Modifier
    override var onModifierChangeIncrement: Int by mutableStateOf(0)
    override var modifierOperationList: List<ModifierOperation> = emptyList()

    var textOverflow by mutableStateOf(TextOverflow.Clip)
    var maxLines by mutableIntStateOf(1)

    override fun generateCode(): String {
        return  """
            Text(
                text = "$text",
                modifier = Modifier
                     ${generateModifier()}
            )""".trimIndent()
    }

    @Composable
    override fun showUi() {
        onModifierChangeIncrement
        Text(
            text = text,
            modifier = modifier,
            overflow = textOverflow,
            maxLines = maxLines,
        )
    }
}

