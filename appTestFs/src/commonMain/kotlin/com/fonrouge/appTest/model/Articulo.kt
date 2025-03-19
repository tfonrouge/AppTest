package com.fonrouge.appTest.model

import com.fonrouge.fsLib.annotations.Collection
import com.fonrouge.fsLib.model.base.BaseDoc
import com.fonrouge.fsLib.serializers.FSOffsetDateTimeSerializer
import com.fonrouge.fsLib.types.StringId
import io.kvision.types.OffsetDateTime
import kotlinx.serialization.Serializable

@Serializable
@Collection(name = "articulos")
data class Articulo(
    override val _id: StringId<Articulo>,
    @Serializable(with = FSOffsetDateTimeSerializer::class)
    val fechaUltimaModificacion: OffsetDateTime,
    val nombre: String,
    val descripcion: String,
    val codigoBarras: String? = null,
    val subFamilia: String,
    val unidadVenta: String,
    val factorVenta: Double,
    val categoria: String,
    val iepsVenta: Int,
    val ivaVenta: Int,
) : BaseDoc<StringId<Articulo>>
