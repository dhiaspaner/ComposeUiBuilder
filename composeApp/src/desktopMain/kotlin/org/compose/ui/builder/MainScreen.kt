package org.compose.ui.builder

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.compose.dnd.DragAndDropContainer
import com.mohamedrejeb.compose.dnd.rememberDragAndDropState
import org.compose.ui.builder.panels.ComponentsPalette
import org.compose.ui.builder.panels.PaletteElements

@Composable
fun MainScreen() {

    val mainViewModel = remember { MainViewModel() }
    val paletteDnDState = rememberDragAndDropState<PaletteElements>()

    DragAndDropContainer(
        state = paletteDnDState,
    ) {
        Row(modifier = Modifier.fillMaxSize()) {

            ComponentsPalette(
                dragState = paletteDnDState,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(300.dp),
                onDragElement = {

                }
            )

            ScreenContent(
                rootContent = mainViewModel.rootComponent
            )


        }
    }
}