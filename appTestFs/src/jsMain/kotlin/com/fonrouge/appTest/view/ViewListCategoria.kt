package com.fonrouge.appTest.view

import com.fonrouge.appTest.common.CommonCategoria
import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewListCategoria
import com.fonrouge.appTest.model.Categoria
import com.fonrouge.fsLib.fieldName
import com.fonrouge.fsLib.lib.UrlParams
import com.fonrouge.fsLib.model.apiData.ApiFilter
import com.fonrouge.fsLib.tabulator.fsTabulator
import com.fonrouge.fsLib.types.OId
import com.fonrouge.fsLib.view.ViewList
import io.kvision.core.Container
import io.kvision.tabulator.ColumnDefinition

class ViewListCategoria(
    override var urlParams: UrlParams
) : ViewList<CommonCategoria, Categoria, OId<Categoria>, ApiFilter, Unit>(
    configView = ConfigViewListCategoria
) {
    override fun columnDefinitionList(): List<ColumnDefinition<Categoria>> = listOf(
        ColumnDefinition(
            title = "Id",
            field = fieldName(Categoria::_id)
        ),
        ColumnDefinition(
            title = "Categoria",
            field = fieldName(Categoria::clave)
        )
    )
    override fun Container.pageListBody(){
        fsTabulator(
            viewList = this@ViewListCategoria
        )
    }
}