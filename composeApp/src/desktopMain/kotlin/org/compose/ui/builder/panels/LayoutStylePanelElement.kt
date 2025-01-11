package org.compose.ui.builder.panels

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.compose.ui.builder.layout.Layout
import org.compose.ui.builder.modifierOperation.BackgroundOperation

@Composable
fun LayoutStylePanelElement(
    layout: Layout,
) {
    val colorList = remember {
        listOf(Color.Red, Color.Blue   , Color.Gray  , Color.Gray  , Color.Gray  )
    }
    Column {

        Text("Pick background color")

        Row {
            colorList.forEach { color ->
                ColorItem(color = color, onClick = { layout.onAddModifierOperation(BackgroundOperation(color)) })
            }
        }
    }
}
@Composable
fun ColorItem(
    color: Color,
    onClick: () -> Unit
) {
    Box(modifier = Modifier
        .size(50.dp)
        .background(color =  color)
        .clickable(onClick = onClick)
    )

}