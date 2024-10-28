package org.compose.ui.builder.layout

import org.compose.ui.builder.component.Component

interface Layout {

    var componentList: List<Component>

    fun addComponent(component: Component) {
        componentList += component
    }

    fun removeComponent(component: Component) {
        componentList -= component
    }

}

