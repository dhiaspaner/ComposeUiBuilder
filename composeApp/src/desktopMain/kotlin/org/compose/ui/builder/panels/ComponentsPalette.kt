package org.compose.ui.builder.panels

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mohamedrejeb.compose.dnd.DragAndDropState
import com.mohamedrejeb.compose.dnd.drag.DraggableItem
import org.compose.ui.builder.MainViewModel


@Composable
fun ComponentsPalette(
    dragState: DragAndDropState<PaletteElements>,
    mainViewModel: MainViewModel,
    onDragElement: (PaletteElements) -> Unit,
    modifier: Modifier
) {

    val elements = remember {
        PaletteElements.entries.toTypedArray()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(elements) {
            DraggableItem(
                key = it.name,
                state = dragState,
                data = it
            ) {
                PalettePreviewItem(
                    text = it.name,
                    modifier = Modifier.fillMaxSize(),
                    onDragElement = { onDragElement(it) }
                )
            }
        }
        item {
            Button(
                onClick = {
                    println(mainViewModel.rootComponent.generateKotlinCode())
                }
            ) {
                Text("Generate Kotlin code")
            }
        }
    }
}