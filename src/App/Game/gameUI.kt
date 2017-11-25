@file:Suppress("UnsafeCastFromDynamic")

package App


import kotlinext.js.js
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import kotlinx.html.title
import org.w3c.dom.Window
import react.RBuilder
import react.RProps
import react.dom.button
import react.dom.div
import react.dom.h1
import kotlin.browser.window


fun RBuilder.gameUI(
        state: AppState,
        props: RProps,
        eh: Eh
) {

    div {

        h1(classes = "title") {
            +"Hello World from React Kotlin - Blackjack"
        }



        buttonBar(eh)

        h1(classes = "subtitle") { +"Action: ${state.g}" }

        div {
            attrs.title = "Foo"
            attrs.style = kotlinext.js.js {
                display = "flex"
            }
            handUI()
            handUI()
        }


    }

}