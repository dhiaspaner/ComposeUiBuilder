package org.compose.ui.builder

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val columnComponent = ColumnComponent()
        columnComponent.onChangeModifier(BackgroundOperation(Color(0xFFFF0541), RoundedCornerShape(4.dp)))
        val textComponent = TextComponent("Text 1")
        val textComponent2 = TextComponent("Text 2")
        val textComponent3 = TextComponent("Text 3")
        val textComponent4 = TextComponent("Text 4")
        val columnComponent2 = ColumnComponent()
        columnComponent2.onChangeModifier(BackgroundOperation(Color.Cyan, RoundedCornerShape(4.dp)))
        columnComponent2.apply {
            addComponent(textComponent)
            addComponent(textComponent2)
            addComponent(textComponent3)
            addComponent(textComponent4)
        }



        columnComponent.addComponent(textComponent)
        columnComponent.addComponent(textComponent2)
        columnComponent.addComponent(textComponent3)
        columnComponent.addComponent(textComponent4)
        columnComponent.addComponent(columnComponent2)


        columnComponent.showUi()

        println("our code  ${columnComponent.generateCode()}")
    }
}