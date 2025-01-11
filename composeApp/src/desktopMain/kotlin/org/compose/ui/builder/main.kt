package org.compose.ui.builder

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.compose.ui.builder.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ComposeUiBuilder",
    ) {
        App()
    }
}