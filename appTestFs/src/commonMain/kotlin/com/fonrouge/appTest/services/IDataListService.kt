package com.fonrouge.appTest.services

import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.fsLib.model.apiData.ApiList
import com.fonrouge.fsLib.model.state.ListState
import io.kvision.annotations.KVService

@KVService
interface IDataListService {
    suspend fun articulo(
        apiList: ApiList<ArticuloFilter>
    ): ListState<Articulo>
}
