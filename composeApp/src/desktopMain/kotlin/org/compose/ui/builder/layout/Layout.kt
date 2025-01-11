package org.compose.ui.builder.layout

import androidx.compose.ui.Modifier
import com.mohamedrejeb.compose.dnd.DragAndDropState
import com.mohamedrejeb.compose.dnd.drop.dropTarget
import org.compose.ui.builder.component.Component
import org.compose.ui.builder.component.TextComponent
import org.compose.ui.builder.panels.PaletteElements

 interface Layout : Component {

    var componentList: List<Component>

    fun addComponent(component: Component) {
        componentList += component
        onModifierChangeIncrement++
    }

    fun removeComponent(component: Component) {
        componentList -= component
        onModifierChangeIncrement++
    }



}

