@file:Suppress("UnsafeCastFromDynamic")

package App

import App.Product.product
import App.TicTacToe.ticTacToe
import App.Todo.todo
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.*
import react.dom.*
import ticker.ticker

interface AppState : RState {
    var g: String
    var selectedExample: String
}

val exampleItems: Array<String>
    get() = arrayOf("Game", "Todo", "TicTacToe", "Product")

class App : RComponent<RProps, AppState>() {
    override fun AppState.init() {
        g = "App Init State"
        selectedExample = exampleItems[2]  //set to TicTacToe which is the main example
    }


    private fun RBuilder.tab() {  //to build the tab bars.  The active tab will according selectedExample to auto set
        div {
            div(classes = "tabs") {
                ul {
                    for (eachTab in exampleItems) {
                        li(classes = if (state.selectedExample == eachTab) "is-active" else "") {
                            key = eachTab
                            a {
                                +eachTab
                                attrs {
                                    onClickFunction = {
                                        setState {
                                            selectedExample = eachTab
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
            div(classes = "box") {
                when (state.selectedExample) {
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
                    "Product" -> product()
                }
            }
        }
    }

    fun RBuilder.menu() {
        div(classes = "navbar is-fixed-top is-transparent") {
            attrs.id = "navbar"

            div(classes = "bd-special-shadow") {
                attrs.id = "specialShadow"
            }
            div(classes = "container") {
                div(classes = "navbar-brand") {
                    attrs.id = "navBrand"
                    a(classes = "navbar-item", href = "https://github.com/ScottHuangZL", target = "_blank") {
                        b {
                            +"Scott Huang"
                        }
                    }
                }

                div(classes = "navbar-menu") {
                    attrs.id = "navMenuIndex"
                    //----------nav bar start/left
                    div(classes = "navbar-start") {
                        //one dropdown
                        div(classes = "navbar-item has-dropdown is-hoverable") {
                            key = "dropdown1"
                            a(classes = "navbar-link", href = "#") {
                                +"Example"
                            }
                            div(classes = "navbar-dropdown is-boxed") {
                                //need a for loop to show examples
                                for (eachExample in exampleItems) {
                                    a(classes = "navbar-item", href = "#") {
                                        key = eachExample
                                        +eachExample
                                        attrs {
                                            onClickFunction = {
                                                setState {
                                                    selectedExample = eachExample
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //another dropdown
                        div(classes = "navbar-item has-dropdown is-hoverable") {
                            key = "dropdown2"

                            a(classes = "navbar-link", href = "#") {
                                +"CSS/Font"
                            }
                            div(classes = "navbar-dropdown is-boxed") {
                                a(classes = "navbar-item", href = "http://fontawesome.io/") {
                                    +"FontAwesome"
                                }
                                a(classes = "navbar-item", href = "#") {
                                    div(classes = "navbar-content") {
                                        p {
                                            small(classes = "has-text-link") {
                                                +"14 Nov 2017"
                                            }
                                        }
                                        p {
                                            +"Bulma is on Patreon!"
                                        }
                                    }
                                }
                                a(classes = "navbar-item", href = "https://bulma.io") {
                                    img("Bulma: a modern CSS framework based on Flexbox", "https://bulma.io/images/bulma-logo.png") {
                                        attrs.style = kotlinext.js.js {
                                            width = "112"
                                            height = "28"
                                        }
                                    }
                                }

                            }
                        }
                        //---------------
                        a(classes = "navbar-item", href = "https://github.com/JetBrains/kotlin-wrappers", target = "_blank") {
                            span(classes = "bd-emoji") {
                                +"⭐️"
                            }
                            +" Kotlin-Wrapper"
                        }
                        a(classes = "navbar-item", href = "https://github.com/JetBrains/create-react-kotlin-app", target = "_blank") {
                            span(classes = "bd-emoji") {
                                +"❤️️"
                            }
                            +" Create-Kotlin-React-App"
                        }

                    }

                    //----------nav bar end/right
                    div(classes = "navbar-end") {
                        attrs.id = "navEnd"
                        a(classes = "navbar-item is-hidden-desktop-only", href = "https://github.com/ScottHuangZL", target = "_blank") {
                            span(classes = "icon") {
                                attrs.style = kotlinext.js.js { color = "#333" }
                                i(classes = "fa fa-lg fa-github") {}
                            }
                        }
                    }
                }
            }
        }
    }

    override fun RBuilder.render() {

        div(classes = "container") {
            menu() //simple static Bulma css style menu.

            div {
                br {}; br {}; br {}
                ticker() // a default simple component to show ticker
                br {}; br {}
            }

            tab() //build in react state to allow dynamic change contents

            for (i in 1..30) {
                br {}
            }
            +"To make the scroll bar appear in right"  //just to check whether the menu bar will fix at top or not

        }
    }

}

fun RBuilder.app() = child(App::class) {}