@file:Suppress("UnsafeCastFromDynamic")

package index

import kotlinext.js.js
import kotlinx.html.style
import react.RBuilder
import react.dom.*


fun RBuilder.menu() {
    div(classes = "navbar is-fixed-top is-transparent") {
        val id = "navbar"
        div(classes = "bd-special-shadow") {
            val id = "specialShadow"
        }
        div(classes = "container") {
            div(classes = "navbar-brand") {
                a(classes = "navbar-item", href = "https://github.com/ScottHuangZL", target = "_blank") {
                    b {
                        +"Scott Huang"
                    }
                }
//                a(classes = "navbar-item", href = "https://bulma.io") {
//                    img("Bulma: a modern CSS framework based on Flexbox", "https://bulma.io/images/bulma-logo.png") {
//                        attrs.style = kotlinext.js.js {
//                            width = "112"
//                            height = "28"
//                        }
//                    }
//                }
            }

            div(classes = "navbar-menu") {
                val id = "navMenuIndex"

                //----------nav bar start/left
                div(classes = "navbar-start") {
                    div(classes = "navbar-item has-dropdown is-hoverable") {
                        a(classes = "navbar-link", href = "#") {
                            +"Sample Menu 1"
                        }
                        div(classes = "navbar-dropdown is-boxed") {
                            a(classes = "navbar-item", href = "#") {
                                +"Overview"
                            }
                            a(classes = "navbar-item", href = "#") {
                                +"Modifiers"
                            }


                            hr(classes = "navbar-divider") {}


                            a(classes = "navbar-item", href = "#") {
                                p(classes = "is-size-6-desktop") {
                                    strong {
                                        +"0.6.1"
                                    }
                                }
                                small {
                                    a(classes = "bd-view-all-versions", href = "#") {
                                        +"View all versions"
                                    }
                                }
                            }
                        }
                    }

                    div(classes = "navbar-item has-dropdown is-hoverable") {
                        a(classes = "navbar-link", href = "#") {
                            +"Sample Menu 2"
                        }
                        div(classes = "navbar-dropdown is-boxed") {
                            a(classes = "navbar-item", href = "#") {
                                +"Overview"
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

                        }
                    }
                    //---------------
                    a(classes = "navbar-item", href = "https://github.com/JetBrains/kotlin-wrappers",target = "_blank") {
                        span(classes = "bd-emoji") {
                            +"⭐️"
                        }
                        +" Kotlin-Wrapper"
                    }
                    a(classes = "navbar-item", href = "https://github.com/JetBrains/create-react-kotlin-app",target = "_blank") {
                        span(classes = "bd-emoji") {
                            +"❤️️"
                        }
                        +" Create-Kotlin-React-App"
                    }

                }

                //----------nav bar end/right
                div(classes = "navbar-end") {
                    a(classes = "navbar-item is-hidden-desktop-only", href = "https://github.com/ScottHuangZL", target = "_blank") {
                        span(classes = "icon") {
                            attrs.style = js { color = "#333;" }
                            i(classes = "fa fa-lg fa-github") {}
                        }
                    }
                }
            }
        }
    }
}