package org.compose.ui.builder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.compose.dnd.DragAndDropState
import com.mohamedrejeb.compose.dnd.drop.dropTarget
import org.compose.ui.builder.panels.PaletteElements

@Composable
fun ScreenContent(
    paletteDnDState: DragAndDropState<PaletteElements>,
    mainViewModel: MainViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .height(500.dp)
            .width(300.dp)
            .background(color = Color.White)
            .dropTarget(
                key = mainViewModel.rootComponent,
                state = paletteDnDState,
                onDrop = {
                }
            )
        ) {
            mainViewModel.rootComponent.showUi()
        }
    }
}