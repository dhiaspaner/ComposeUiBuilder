package org.compose.ui.builder

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.compose.dnd.DragAndDropContainer
import com.mohamedrejeb.compose.dnd.rememberDragAndDropState
import org.compose.ui.builder.component.TextComponent
import org.compose.ui.builder.layout.BoxLayout
import org.compose.ui.builder.layout.ColumnLayout
import org.compose.ui.builder.panels.ComponentsPalette
import org.compose.ui.builder.panels.LayoutStylePanelElement
import org.compose.ui.builder.panels.PaletteElements
import org.compose.ui.builder.panels.TextStylePanel

@Composable
fun MainScreen() {

    val paletteDnDState = rememberDragAndDropState<PaletteElements>()
    val mainViewModel = remember { MainViewModel(paletteDnDState) }
    DragAndDropContainer(
        state = paletteDnDState,
    ) {
        Row(modifier = Modifier.fillMaxSize()) {

            ComponentsPalette(
                dragState = paletteDnDState,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(300.dp)
                    .pointerInput(Unit) {
                        detectTapGestures() {
                            mainViewModel.unselectAllComponents()
                        }
                    }
                ,
                mainViewModel = mainViewModel,
                onDragElement = {

                }
            )

            ScreenContent(
                mainViewModel = mainViewModel,
                paletteDnDState = paletteDnDState,
            )

            if (mainViewModel.selectedComponent != null) {
                mainViewModel.selectedComponent?.let { selectedComponent ->
                    println("compose selected comp")
                    when (selectedComponent) {
                        is TextComponent -> TextStylePanel(selectedComponent)
                    }
                }
            } else {
                mainViewModel.selectedLayout?.let { selectedLayout ->
                   LayoutStylePanelElement(selectedLayout)
                }
            }

        }
    }
}