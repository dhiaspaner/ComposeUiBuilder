package org.compose.ui.builder

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.compose.ui.builder.component.TextComponent
import org.compose.ui.builder.layout.ColumnLayout
import org.compose.ui.builder.modifierOperation.BackgroundOperation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val columnLayout = ColumnLayout()
        columnLayout.onChangeModifier(BackgroundOperation(Color(0xFFFF0541), RoundedCornerShape(4.dp)))
        val textComponent = TextComponent("Text 1")
        val textComponent2 = TextComponent("Text 2")
        val textComponent3 = TextComponent("Text 3")
        val textComponent4 = TextComponent("Text 4")
        val columnLayout2 = ColumnLayout()
        columnLayout2.onChangeModifier(BackgroundOperation(Color.Cyan, RoundedCornerShape(4.dp)))
        columnLayout2.apply {
            addComponent(textComponent)
            addComponent(textComponent2)
            addComponent(textComponent3)
            addComponent(textComponent4)
        }



        columnLayout.addComponent(textComponent)
        columnLayout.addComponent(textComponent2)
        columnLayout.addComponent(textComponent3)
        columnLayout.addComponent(textComponent4)
        columnLayout.addComponent(columnLayout2)


        columnLayout.showUi()

        println("our code  ${columnLayout.generateCode()}")
    }
}