package com.fonrouge.appTest.view

import com.fonrouge.appTest.common.CommonArticulo
import com.fonrouge.appTest.config.ConfigViewImpl.Companion.ConfigViewItemArticulo
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.fsLib.layout.formColumn
import com.fonrouge.fsLib.layout.formRow
import com.fonrouge.fsLib.lib.UrlParams
import com.fonrouge.fsLib.types.StringId
import com.fonrouge.fsLib.view.ViewItem
import io.kvision.core.Container
import io.kvision.form.FormPanel
import io.kvision.form.formPanel
import io.kvision.form.text.text
import io.kvision.form.text.textArea

class ViewItemArticulo(
    override var urlParams: UrlParams
) : ViewItem<CommonArticulo, Articulo, StringId<Articulo>, ArticuloFilter>(
    configView = ConfigViewItemArticulo
) {
    override fun Container.pageItemBody(): FormPanel<Articulo> = formPanel {
        formRow {
            formColumn(2) {
                text(label = "Id") {
                    disabled = true
                }.bindCustom(key = Articulo::_id, required = true)
            }
        }
        formRow {
            formColumn(12) {
                text(label = "Nombre").bind(key = Articulo::nombre, required = true)
            }
        }
        formRow {
            formColumn(12) {
                textArea(label = "Descripcion").bind(key = Articulo::descripcion)
            }
        }
    }
}
