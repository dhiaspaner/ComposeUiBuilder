package org.compose.ui.builder.component

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import org.compose.ui.builder.modifierOperation.ModifierOperation

class TextComponent(
    value: String,
) : Component {

    override var modifier: Modifier = Modifier
    override var onModifierChangeIncrement: Int by mutableStateOf(0)
    override var modifierOperationList: List<ModifierOperation> = emptyList()

    override var onClick = {}
    var textValue by mutableStateOf("")

    init {
        textValue = value
    }
    var textOverflow by mutableStateOf(TextOverflow.Clip)
    var maxLines by mutableIntStateOf(1)

    override var isHovered by mutableStateOf(false)
    override var isSelected by mutableStateOf(false)

    override fun generateKotlinCode(): String {
        return  """
            Text(
                text = "$textValue",
                modifier = ${generateModifier()}
            )""".trimIndent()
    }

    @Composable
    override fun showUi() {
        onModifierChangeIncrement
        Text(
            text = textValue,
            modifier = modifier.pointerInput(Unit) {
                detectTapGestures() {
                    println("text is selected")
                    isSelected = true
                    onClick()
                }

            },
            overflow = textOverflow,
            maxLines = maxLines,
        )
    }
}