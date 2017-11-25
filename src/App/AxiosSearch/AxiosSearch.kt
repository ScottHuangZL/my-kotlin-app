@file:Suppress("UnsafeCastFromDynamic")

package App.AxiosSearch

/**
 * An example to show how to leverage axios lib to fetch remote data by Scott_Huang@qq.com (Zhiliang.Huang@gmail.com)
 * (Btw, Vue.js formally leverage axios for ajax related works, so it should be good if React.js also use it)
 *
 * Date: Nov 25, 2017
 */

import kotlinext.js.js

import kotlinx.html.*
import kotlinx.html.js.*
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*

data class ZipResult(val country: String, val state: String, val city: String)
interface AxiosProps : RProps {
}

interface AxiosState : RState {
    var zipCode: String
    var zipResult: ZipResult
}

// You need input correct axios.min.js link address in public\static\index.html
// I personally download axios.min.js proactive in put it into public\static\js folder
// <script src="%PUBLIC_URL%/static/js/axios.min.js"></script>
// or you can put   <script src="https://unpkg.com/axios/dist/axios.min.js"></script>     into index.html to avoid proactive download to local
// And we provide a simple fun to wrap axios.js, it is not type safe, suggest JB team to provide a formal wrapping for this useful lib
external fun axios(config: dynamic): dynamic


class AxiosSearch(props: AxiosProps) : RComponent<AxiosProps, AxiosState>(props) {
    override fun AxiosState.init(props: AxiosProps) {
        zipCode = ""
        zipResult = ZipResult("", "", "")
    }

    override fun RBuilder.render() {
        val infoText = "Input USA 5 digit zip code below... such as 90210 or 24124 or any valid zip code."
        div {
            p { +infoText }
            input(type = InputType.text, name = "zipCode") {
                key = "zipCode"
                attrs {
                    value = state.zipCode
                    placeholder = "Input zip code ..."
                    title = infoText
                    onChangeFunction = {
                        val target = it.target as HTMLInputElement
                        setState {
                            zipCode = target.value
                            zipResult = ZipResult("", "", "")
                        }
                        if (target.value.length == 5) {
                            axios(js {
                                url = "http://ziptasticapi.com/" + target.value
                                timeout = 3000
                            }).then({ response ->
                                setState {
                                    zipResult = ZipResult(response.data.country, response.data.state, response.data.city)
                                }
                            }).catch(p0 = { error ->
                                setState {
                                    zipResult = ZipResult("", "", "Find error, please open your console to learn detail.")
                                }
                                console.log(error)
                            })
                        }
                    }
                }
            }
            br {}
            h1 {
                +"zip code ${state.zipCode} detail result is: "
                +"${state.zipResult.country} ${state.zipResult.state} ${state.zipResult.city} "
            }
        }
    }
}

fun RBuilder.axiosSearch() = child(AxiosSearch::class) {
}
