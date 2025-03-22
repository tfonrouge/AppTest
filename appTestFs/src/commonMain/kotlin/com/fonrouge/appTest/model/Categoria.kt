package com.fonrouge.appTest.model

import com.fonrouge.fsLib.annotations.Collection
import com.fonrouge.fsLib.model.base.BaseDoc
import com.fonrouge.fsLib.types.OId
import kotlinx.serialization.Serializable


@Serializable
@Collection(name ="categoria")
data class Categoria(
    override val _id: OId<Categoria> = OId(),
    val clave: String,
) : BaseDoc<OId<Categoria>>