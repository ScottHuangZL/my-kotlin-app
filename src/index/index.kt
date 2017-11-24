@file:Suppress("UnsafeCastFromDynamic")

package index

import App.app
import react.dom.*
import kotlin.browser.*
import kotlinext.js.*

fun main(args: Array<String>) {
    val rootDiv = document.getElementById("root")
    require("src/App/TicTacToe/TicTacToe.css")
    render(rootDiv) {
        app(
        )
    }
}

