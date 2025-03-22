package com.fonrouge.appTest.config

import com.fonrouge.appTest.common.CommonArticulo
import com.fonrouge.appTest.common.CommonCategoria
import com.fonrouge.appTest.common.CommonHome
import com.fonrouge.appTest.services.IDataItemService
import com.fonrouge.appTest.services.IDataListService
import com.fonrouge.appTest.view.*
import com.fonrouge.fsLib.config.*

class ConfigViewImpl : IConfigView {
    companion object {
        val ConfigViewHome = configView(
            viewKClass = ViewHome::class,
            commonContainer = CommonHome,
            baseUrl = ""
        )

        val ConfigViewItemCategoria = configViewItem(
            viewKClass = ViewItemCategoria::class,
            commonContainer = CommonCategoria,
            apiItemFun = IDataItemService::categoria
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

        val ConfigViewListCategoria = configViewList(
            viewKClass = ViewListCategoria::class,
            commonContainer = CommonCategoria,
            apiListFun = IDataListService::categoria
        )
    }
}