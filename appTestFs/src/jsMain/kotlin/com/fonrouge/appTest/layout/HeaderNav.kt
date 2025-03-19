package com.fonrouge.appTest.layout

import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewHome
import com.fonrouge.fsLib.view.AppScope
import com.fonrouge.fsLib.view.KVWebManager.frontEndAppName
import com.fonrouge.fsLib.view.KVWebManager.frontEndVersion
import com.fonrouge.fsLib.view.KVWebManager.motto
import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.flexPanel
import io.kvision.utils.em
import io.kvision.utils.px
import io.kvision.utils.rem
import kotlinx.browser.window
import kotlinx.coroutines.launch

fun Container.headerNav() {
    nav(className = "navbar navbar-light") {
        div(className = "container") {
            image(src = "img.png", responsive = true) {
                onClick {
                    window.open("https://fonrouge-yutani.com", "_blank")
                }
                cursor = Cursor.POINTER
                height = 4.em
                resize = Resize.BOTH
            }
            div(className = "row") {
                flexDirection = FlexDirection.COLUMN
                flexPanel(
                    FlexDirection.ROW, FlexWrap.NOWRAP, JustifyContent.FLEXSTART, AlignItems.BASELINE
                ) {
                    link(frontEndAppName, ConfigViewHome.url, className = "navbar-brand")
                    div(content = "v${frontEndVersion}", className = "nav_item") {
                        fontSize = 0.6.rem
                    }
                }
                link(motto) {
                    fontSize = 12.px
                }
            }
            ul(className = "nav navbar-nav pull-xs-right") {
                li(className = "nav-item") {
                    link("Home", ConfigViewHome.url, className = "nav-link active")
                }
                if (true) {
                    li(className = "nav-item") {
                        link("Login", className = "nav-link active").onClick {
                            AppScope.launch {
/*
                                if (!Security.login()) {
                                    Toast.warning("Login failed ...")
                                }
*/
                            }
                        }
                    }
                }
            }
        }
    }
}
