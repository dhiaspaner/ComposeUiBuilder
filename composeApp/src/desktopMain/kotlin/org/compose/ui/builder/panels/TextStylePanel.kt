package org.compose.ui.builder.panels

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.compose.ui.builder.component.TextComponent


@Composable
fun TextStylePanel(
    textComponent: TextComponent,
) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .fillMaxHeight()
    ) {

        Text(text = "value : ")

        TextField(
            value = textComponent.textValue,
            onValueChange = {
                textComponent.textValue = it
            },
            modifier = Modifier
                .height(50.dp)
        )

    }
}