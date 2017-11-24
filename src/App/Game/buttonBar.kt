@file:Suppress("UnsafeCastFromDynamic")

package App

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.dom.button
import react.dom.div
import react.dom.i

interface Eh {
    fun deal()
    fun hit()
    fun stay()
}

fun RBuilder.buttonBar(eh: Eh) {
    div {
        button(classes = "button is-primary") {
            i(classes = "fa fa-home") {
                +"   "
                +"Deal"
            }
            attrs.onClickFunction = {
                eh.deal()
                console.log(it)
            }
        }
        button(classes = "button is-info") {
            i(classes = "fa fa-spin") {
                +"   "
                +"Hit"
            }
            attrs.onClickFunction = {
                eh.hit()
            }
        }
        button(classes = "button is-success") {
            +"Stay"
            attrs.onClickFunction = {
                eh.stay()
            }
        }
    }
}