package ExampleApp

import App.TicTacToe.ticTacToe
import App.Todo.todo
import index.menu
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import ticker.ticker

interface AppState : RState {
    var g: String
    var selectedTab: String
}

val tabItems = arrayOf("Game", "Todo", "TicTacToe")

class App : RComponent<RProps, AppState>() {
    override fun AppState.init() {
        g = "App Init State"
        selectedTab = tabItems[2]  //set to TicTacToe which is the main example
    }

    private fun RBuilder.tab() {  //to build the tab bars.  The active tab will according selectedTab to auto set
        div {
            div(classes = "tabs") {
                ul {
                    for (eachTab in tabItems) {
                        li(classes = if (state.selectedTab == eachTab) "is-active" else "") {
                            a {
                                +eachTab
                                attrs {
                                    onClickFunction = {
                                        setState {
                                            selectedTab = eachTab
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
            div(classes = "box") {
                when (state.selectedTab) {
                    "Game" -> gameUI(state, props, object : Eh {
                        override fun deal() {
                            //                console.log("Deal in App")
                            setState {
                                g = "deal"
                            }
                        }

                        override fun hit() {
                            //                console.log("Hit in App")
                            setState {
                                g = "hit"
                            }
                        }

                        override fun stay() {
                            //                console.log("Stay in App")
                            setState {
                                g = "Stay"
                            }
                        }
                    })
                    "Todo" -> todo()
                    "TicTacToe" -> ticTacToe()
                }
            }
        }
    }

    override fun RBuilder.render() {
        menu() //simple static Bulma css style menu.
        div(classes = "container") {
            div {
                br {}; br {}; br {}
                ticker() // a default simple component to show ticker
                br {}; br {}
            }

            tab() //build in react state to allow dynamic change contents

            for (i in 1..30) {
                br { }
            }
            +"To make the scroll bar appear in right"  //just to check whether the menu bar will fix at top or not

        }

    }

}

fun RBuilder.app() = child(App::class) {}