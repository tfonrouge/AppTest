package com.fonrouge.appTest.common

import com.fonrouge.appTest.model.Categoria
import com.fonrouge.fsLib.common.ICommonContainer
import com.fonrouge.fsLib.model.apiData.ApiFilter
import com.fonrouge.fsLib.types.OId
import kotlinx.serialization.serializer

data object CommonCategoria : ICommonContainer<Categoria, OId<Categoria>, ApiFilter>(
    itemKClass = Categoria::class,
    idSerializer = serializer(),
    apiFilterSerializer = serializer(),
    labelItem = "Categoria",
    labelList = "Categorias"
)