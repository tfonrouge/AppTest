package com.fonrouge.appTest.view

import com.fonrouge.appTest.common.CommonCategoria
import com.fonrouge.appTest.model.Categoria
import com.fonrouge.fsLib.lib.UrlParams
import com.fonrouge.fsLib.model.apiData.ApiFilter
import com.fonrouge.fsLib.types.OId
import com.fonrouge.fsLib.view.ViewItem
import io.kvision.core.Container
import io.kvision.form.FormPanel
import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewItemCategoria

class ViewItemCategoria (
    override var urlParams: UrlParams
) : ViewItem<CommonCategoria, Categoria, OId<Categoria>, ApiFilter>(
    configView = ConfigViewItemCategoria
){
    override fun Container.pageItemBody(): FormPanel<Categoria>? {
        TODO("Not yet implemented")
    }
}