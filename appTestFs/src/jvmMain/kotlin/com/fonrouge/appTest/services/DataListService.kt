package com.fonrouge.appTest.services

import com.fonrouge.appTest.coll.Collections.ArticuloColl
import com.fonrouge.appTest.coll.Collections.CategoriaColl
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.appTest.model.Categoria
import com.fonrouge.fsLib.model.apiData.ApiFilter
import com.fonrouge.fsLib.model.apiData.ApiList
import com.fonrouge.fsLib.model.state.ListState
import org.bson.conversions.Bson
import org.litote.kmongo.and
import org.litote.kmongo.eq

actual class DataListService : IDataListService {

    override suspend fun articulo(apiList: ApiList<ArticuloFilter>): ListState<Articulo> {
        val matchDoc = mutableListOf<Bson>()
        apiList.apiFilter.categoria?.let { matchDoc.add(Articulo::categoria eq it)}

        return ArticuloColl.apiListProcess(
            preLookupMatch = and(matchDoc),
            apiList = apiList,
        )
    }

    override suspend fun categoria(apiList: ApiList<ApiFilter>): ListState<Categoria>{
        return CategoriaColl.apiListProcess(apiList = apiList)
    }

}