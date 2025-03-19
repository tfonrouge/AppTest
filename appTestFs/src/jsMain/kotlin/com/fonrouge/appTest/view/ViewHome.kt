package com.fonrouge.appTest.view

import com.fonrouge.appTest.common.CommonHome
import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewHome
import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewListArticulo
import com.fonrouge.fsLib.layout.centeredMessage
import com.fonrouge.fsLib.layout.formColumn
import com.fonrouge.fsLib.lib.UrlParams
import com.fonrouge.fsLib.model.apiData.ApiFilter
import com.fonrouge.fsLib.view.KVWebManager.routing
import com.fonrouge.fsLib.view.View
import io.kvision.core.AlignItems
import io.kvision.core.Container
import io.kvision.core.JustifyContent
import io.kvision.html.Align
import io.kvision.html.Div
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.vPanel
import io.kvision.types.toStringF
import io.kvision.utils.em
import kotlinx.browser.window
import kotlin.js.Date

var clockHandle: Int? = null
    set(value) {
        field?.let { window.clearInterval(it) }
        field = value
    }

class ViewHome(override var urlParams: UrlParams) : View<CommonHome, ApiFilter>(configView = ConfigViewHome) {
    override fun Container.displayPage() {
        lateinit var centralDiv: Div
        routing.updatePageLinks()

        pageBanner()

        vPanel(spacing = 20, alignItems = AlignItems.CENTER) {
            formColumn(1) {
                button(icon = "fas fa-home", text = "Articulos").onClick {
                    ConfigViewListArticulo.navigateTo()
                }
            }
        }

        div(className = "container") {
            align = Align.CENTER
            id = "selectorDiv"
            centralDiv = centeredMessage(Date().toStringF("hh:mm:ss a")) {
                fontFamily = "Orbitron"
                fontSize = 5.em
            }
        }
        clockHandle = window.setInterval({
//            centralDiv.content = Date().toStringF(dateFormat)
            centralDiv.content = Date().toStringF("hh:mm:ss a")
        }, 1000)
    }
}
