package com.fonrouge.appTest.model

import com.fonrouge.fsLib.model.apiData.IApiFilter
import kotlinx.serialization.Serializable

@Serializable
data class ArticuloFilter(
    val categoria: String? = null
) : IApiFilter<Unit>()
