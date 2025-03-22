package com.fonrouge.appTest.coll

import com.fonrouge.appTest.common.CommonArticulo
import com.fonrouge.appTest.common.CommonCategoria
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.appTest.model.Categoria
import com.fonrouge.fsLib.model.apiData.ApiFilter
import com.fonrouge.fsLib.mongoDb.Coll
import com.fonrouge.fsLib.types.OId
import com.fonrouge.fsLib.types.StringId

object Collections {
    val ArticuloColl =
        object : Coll<CommonArticulo, Articulo, StringId<Articulo>, ArticuloFilter>(
            commonContainer = CommonArticulo
        ) {}

    val CategoriaColl =
        object : Coll<CommonCategoria, Categoria, OId<Categoria>, ApiFilter>(
            commonContainer = CommonCategoria
        ) {}
}
