package com.fonrouge.appTest.services

import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.fsLib.model.apiData.ApiItem
import com.fonrouge.fsLib.model.apiData.IApiItem
import com.fonrouge.fsLib.model.state.ItemState
import com.fonrouge.fsLib.types.StringId
import io.kvision.annotations.KVService

@KVService
interface IDataItemService {
    suspend fun articulo(
        iApiItem: IApiItem<Articulo, StringId<Articulo>, ArticuloFilter>
    ): ItemState<Articulo>
}
