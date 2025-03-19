package com.fonrouge.appTest

import com.fonrouge.appTest.config.ConfigViewImpl
import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewHome
import com.fonrouge.appTest.layout.headerNav
import com.fonrouge.appTest.services.DataItemServiceManager
import com.fonrouge.appTest.services.DataListServiceManager
import com.fonrouge.appTest.view.clockHandle
import com.fonrouge.fsLib.config.ConfigViewItem
import com.fonrouge.fsLib.config.ConfigViewList
import com.fonrouge.fsLib.layout.centeredMessage
import com.fonrouge.fsLib.view.KVWebManager
import com.fonrouge.fsLib.view.KVWebManager.viewStateObservableValue
import com.fonrouge.fsLib.view.showView
import io.kvision.*
import io.kvision.html.header
import io.kvision.html.main
import io.kvision.i18n.I18n
import io.kvision.pace.Pace
import io.kvision.panel.root
import io.kvision.state.bind
import io.kvision.toast.Toast
import io.kvision.toast.ToastOptions
import io.kvision.toast.ToastPosition
import io.kvision.types.KV_DEFAULT_DATE_FORMAT
import kotlinx.browser.window

class App : Application() {
    init {
        Pace.init(require("./css/bounce.css"))
        ConfigViewItem.serviceManager = DataItemServiceManager
        ConfigViewList.serviceManager = DataListServiceManager
    }

    override fun start(state: Map<String, Any>) {
        require("./css/app.css")
        KVWebManager.initialize {
            Toast.info(
                message = "Host: ${window.document.location?.hostname}",
                options = ToastOptions(
                    position = ToastPosition.BOTTOMLEFT,
                )
            )
            periodicUpdateDataViewList = true
            configViewHome = ConfigViewHome

            frontEndAppName = "AppTest"
            motto = "AppTest is an fullstack app that helps you to discover the latest fsLib™ features"
            frontEndVersion = "1.0"

            iConfigView = ConfigViewImpl()
            KV_DEFAULT_DATE_FORMAT = "isoDateTime"
        }
        root("kvapp") {
            header().bind(viewStateObservableValue) {
                headerNav()
            }
            main().bind(viewStateObservableValue) { viewState ->
                clockHandle = null
                if (viewState != null) {
                    showView(viewState)
                } else {
                    centeredMessage("Page not Found ... ")
                }
            }
        }
    }
}

fun main() {
    I18n.language = "es"
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        DatetimeModule,
        RichTextModule,
        TomSelectModule,
        BootstrapUploadModule,
        ImaskModule,
        ToastifyModule,
        FontAwesomeModule,
        BootstrapIconsModule,
        PrintModule,
        ChartModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
//        MapsModule,
        CoreModule
    )
}
