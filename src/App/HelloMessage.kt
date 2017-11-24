package App

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1

interface HelloMessageProps : RProps {
    var message: String
}

class HelloMessage(message: HelloMessageProps) : RComponent<HelloMessageProps, RState>() {

    override fun RBuilder.render() {
        h1 {
            + props.message
        }
    }
}

fun RBuilder.helloMessage(message: String = "Hello World") = child(HelloMessage::class) {
    attrs.message = message
}