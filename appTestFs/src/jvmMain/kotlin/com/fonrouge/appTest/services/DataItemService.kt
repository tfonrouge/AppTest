package com.fonrouge.appTest.services

import com.fonrouge.appTest.coll.Collections.ArticuloColl
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.fsLib.model.apiData.IApiItem
import com.fonrouge.fsLib.model.state.ItemState
import com.fonrouge.fsLib.types.StringId

actual class DataItemService : IDataItemService {
    override suspend fun articulo(
        iApiItem: IApiItem<Articulo, StringId<Articulo>, ArticuloFilter>
    ): ItemState<Articulo> = ArticuloColl.apiItemProcess(iApiItem = iApiItem, call = null)
}
