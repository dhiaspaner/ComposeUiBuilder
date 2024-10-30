package org.compose.ui.builder.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import org.compose.ui.builder.modifierOperation.ModifierOperation

class TextComponent(private val text: String) : Component {

    override var modifier: Modifier = Modifier
    override var onModifierChangeIncrement: Int by mutableStateOf(0)
    override var modifierOperationList: List<ModifierOperation> = emptyList()

    var textOverflow by mutableStateOf(TextOverflow.Clip)
    var maxLines by mutableIntStateOf(1)

    override fun generateKotlinCode(): String {
        return  """
            Text(
                text = "$text",
                modifier = ${generateModifier()}
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