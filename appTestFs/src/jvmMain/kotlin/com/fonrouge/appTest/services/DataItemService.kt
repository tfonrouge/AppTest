package com.fonrouge.appTest.services

import com.fonrouge.appTest.coll.Collections.ArticuloColl
import com.fonrouge.appTest.coll.Collections.CategoriaColl
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.appTest.model.Categoria
import com.fonrouge.fsLib.model.apiData.ApiFilter
import com.fonrouge.fsLib.model.apiData.IApiItem
import com.fonrouge.fsLib.model.state.ItemState
import com.fonrouge.fsLib.types.OId
import com.fonrouge.fsLib.types.StringId

actual class DataItemService : IDataItemService {
    override suspend fun articulo(
        iApiItem: IApiItem<Articulo, StringId<Articulo>, ArticuloFilter>
    ): ItemState<Articulo> = ArticuloColl.apiItemProcess(iApiItem = iApiItem, call = null)

    override suspend fun categoria(iApiItem: IApiItem<Categoria, OId<Categoria>, ApiFilter>): ItemState<Categoria> {
        return CategoriaColl.apiItemProcess(iApiItem = iApiItem, call = null)
    }
}
