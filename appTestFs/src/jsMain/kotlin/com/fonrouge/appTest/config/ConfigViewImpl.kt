package com.fonrouge.appTest.config

import com.fonrouge.appTest.common.CommonArticulo
import com.fonrouge.appTest.common.CommonHome
import com.fonrouge.appTest.services.IDataItemService
import com.fonrouge.appTest.services.IDataListService
import com.fonrouge.appTest.view.ViewHome
import com.fonrouge.appTest.view.ViewItemArticulo
import com.fonrouge.appTest.view.ViewListArticulo
import com.fonrouge.fsLib.config.IConfigView
import com.fonrouge.fsLib.config.configView
import com.fonrouge.fsLib.config.configViewItem
import com.fonrouge.fsLib.config.configViewList

class ConfigViewImpl : IConfigView {
    companion object {
        val ConfigViewHome = configView(
            viewKClass = ViewHome::class,
            commonContainer = CommonHome,
            baseUrl = ""
        )

        val ConfigViewItemArticulo = configViewItem(
            viewKClass = ViewItemArticulo::class,
            commonContainer = CommonArticulo,
            apiItemFun = IDataItemService::articulo,
        )

        val ConfigViewListArticulo = configViewList(
            viewKClass = ViewListArticulo::class,
            commonContainer = CommonArticulo,
            apiListFun = IDataListService::articulo
        )
    }
}