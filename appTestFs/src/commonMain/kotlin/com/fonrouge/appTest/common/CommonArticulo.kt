package com.fonrouge.appTest.common

import com.fonrouge.appTest.model.Articulo
import com.fonrouge.appTest.model.ArticuloFilter
import com.fonrouge.fsLib.common.ICommonContainer
import com.fonrouge.fsLib.types.StringId
import kotlinx.serialization.serializer

data object CommonArticulo : ICommonContainer<Articulo, StringId<Articulo>, ArticuloFilter>(
    itemKClass = Articulo::class,
    idSerializer = serializer(),
    apiFilterSerializer = serializer(),
    labelItem = "Artículo",
    labelList = "Artículos"
)
