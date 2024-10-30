package org.compose.ui.builder.panels

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PalettePreviewItem(
    icon: @Composable () -> Unit = {},
    text: String,
    onDragElement: () -> Unit = {},
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        icon()

        Text(
            text = text,
        )
    }
}