package com.fonrouge.appTest.view

import com.fonrouge.appTest.common.CommonArticulo
import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewListArticulo
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.appTest.services.ISelectService
import com.fonrouge.appTest.services.SelectServiceManager
import com.fonrouge.fsLib.fieldName
import com.fonrouge.fsLib.lib.UrlParams
import com.fonrouge.fsLib.tabulator.fsTabulator
import com.fonrouge.fsLib.types.StringId
import com.fonrouge.fsLib.view.ViewList
import io.kvision.core.Container
import io.kvision.form.select.tomSelectRemote
import io.kvision.offcanvas.Offcanvas
import io.kvision.offcanvas.offcanvas
import io.kvision.tabulator.ColumnDefinition

class ViewListArticulo(
    override var urlParams: UrlParams
) : ViewList<CommonArticulo, Articulo, StringId<Articulo>, ArticuloFilter, Unit>(
    configView = ConfigViewListArticulo
) {
    override fun columnDefinitionList(): List<ColumnDefinition<Articulo>> = listOf(
        ColumnDefinition(
            title = "Id",
            field = fieldName(Articulo::_id)
        ),
        ColumnDefinition(
            title = "Nombre",
            field = fieldName(Articulo::nombre)
        ),
        ColumnDefinition(
            title = "Descripcion",
            field = fieldName(Articulo::descripcion)
        ),
        ColumnDefinition(
            title = "Categoria",
            field = fieldName(Articulo::categoria)
        )
    )

    override fun Container.buildOffCanvasFilterView(): Offcanvas = offcanvas(caption = "Filtros") {
        tomSelectRemote(
            label = "Categoria",
            serviceManager = SelectServiceManager,
            function = ISelectService::articulo,
            openOnFocus = true,
        )
    }

    override fun Container.pageListBody() {
        fsTabulator(
            viewList = this@ViewListArticulo
        )
    }
}