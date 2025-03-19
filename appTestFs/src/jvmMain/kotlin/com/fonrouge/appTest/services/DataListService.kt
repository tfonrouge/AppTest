package com.fonrouge.appTest.services

import com.fonrouge.appTest.coll.Collections.ArticuloColl
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.fsLib.model.apiData.ApiList
import com.fonrouge.fsLib.model.state.ListState

actual class DataListService : IDataListService {
    override suspend fun articulo(apiList: ApiList<ArticuloFilter>): ListState<Articulo> =
        ArticuloColl.apiListProcess(call = null, apiList = apiList)
}