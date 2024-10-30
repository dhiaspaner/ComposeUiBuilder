package org.compose.ui.builder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.compose.ui.builder.component.Component
import org.compose.ui.builder.layout.BoxLayout
import org.compose.ui.builder.layout.Layout
import org.compose.ui.builder.panels.PaletteElements

class MainViewModel {

    var draggedElement by mutableStateOf(PaletteElements.None)

    var hoveredLayout by mutableStateOf<Layout?>(null)

    var selectedComponent by mutableStateOf<Component?>(null)

    val rootComponent: Component = BoxLayout()




}