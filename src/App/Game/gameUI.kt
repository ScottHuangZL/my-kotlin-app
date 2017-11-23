@file:Suppress("UnsafeCastFromDynamic")

package ExampleApp


import kotlinx.html.style
import kotlinx.html.title
import react.RBuilder
import react.RProps
import react.dom.div
import react.dom.h1


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