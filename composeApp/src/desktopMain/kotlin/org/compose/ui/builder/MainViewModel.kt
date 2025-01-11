package org.compose.ui.builder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mohamedrejeb.compose.dnd.DragAndDropState
import com.mohamedrejeb.compose.dnd.drop.dropTarget
import org.compose.ui.builder.component.Component
import org.compose.ui.builder.component.TextComponent
import org.compose.ui.builder.layout.BoxLayout
import org.compose.ui.builder.layout.ColumnLayout
import org.compose.ui.builder.layout.Layout
import org.compose.ui.builder.panels.PaletteElements

class MainViewModel(dndState: DragAndDropState<PaletteElements>) {


    private var onClickIncrement by mutableIntStateOf(0)
    var selectedComponent by mutableStateOf<Component?>(null)
    var selectedLayout by mutableStateOf<Layout?>(null)

    val rootComponent: Layout = BoxLayout()

    fun onDropComponent(paletteElement: PaletteElements, layout: Layout) {
        val component = when (paletteElement) {
            PaletteElements.Box -> BoxLayout()
            PaletteElements.Column -> ColumnLayout()
            PaletteElements.Text -> TextComponent("Hello world!")
        }
        component.apply {
            onClick = {
                onSelectComponent()
                onClickIncrement++
            }
        }
        layout.addComponent(component)
    }

    init {
        rootComponent.modifier = rootComponent.modifier.dropTarget<PaletteElements>(
            state = dndState,
            key = "rootComponent",
            onDrop = {
                val paletteElement = it.data
                val lastHoveredLayout = getTheLastHoveredLayout()
                onDropComponent(paletteElement = paletteElement, layout = lastHoveredLayout)
            },
        )
        rootComponent.onClick = {
            unselectAllComponents()
            onSelectComponent()
            onClickIncrement++

        }
        rootComponent.onModifierChangeIncrement++
    }

    fun getTheLastHoveredLayout(): Layout {
        var nextLayout: Layout? = rootComponent.componentList
            .filterIsInstance<Layout>()
            .find { layout -> layout.isHovered } ?: return rootComponent

        var hoveredLayout: Layout = nextLayout!!

        while (nextLayout != null) {
            nextLayout = nextLayout.componentList
                .filterIsInstance<Layout>()
                .find { layout -> layout.isHovered }
            if (nextLayout != null) {
                hoveredLayout = nextLayout
            }
        }
        return hoveredLayout
    }

    fun onSelectComponent() {
        val lastLayout = getTheLastHoveredLayout()

        val selectedComponent = lastLayout.componentList.firstOrNull { it.isSelected }
        if (selectedComponent != null)
            this@MainViewModel.selectedComponent = selectedComponent
//        else  selectedLayout = lastLayout
    }

    fun unselectAllComponents(root: Component = rootComponent) {
        root.isSelected = false
        if (root is Layout) {
            root.componentList.forEach { layout ->
                unselectAllComponents(layout)
            }
        }
    }




}

fun rotateString(s: String, goal: String): Boolean {
    var i = 0
    var shiftedGoal = goal
    val goalLength = s.length
    if (s.length == goal.length) {
        return false
    }
    while(i < goalLength && shiftedGoal != s) {
        shiftedGoal = shiftedGoal.last() + shiftedGoal.substring(0,goalLength-1)
        i ++
        println("$i $shiftedGoal")

    }
    println("$i $shiftedGoal")
    val regex = Regex("[(]*[)]}")
    ":".replace(regex,"?")
    return shiftedGoal == s
}

fun evaluate(s: String, knowledge: List<List<String>>): String {
        val myKeyValueKnowledge = knowledge.associate {
            "(${it[0]})" to  it[1]
        }
        val regex = Regex("\\((.*?)\\)")
        return s.replace(regex) {
            val newValue = myKeyValueKnowledge.getOrDefault(it.value,"?")
            newValue

        }
}

class A(val s: MutableList<String>) {
    fun add(a: String) {
        s.add(a)
    }
}
fun main() {
    val mList = mutableListOf<String>()
    mList.add("Hello world!")

    val a = A(mList)
    a.add(" AAA AAAA")
    println(mList)

}

