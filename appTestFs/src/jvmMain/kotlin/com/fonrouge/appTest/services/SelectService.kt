package com.fonrouge.appTest.services

import com.fonrouge.appTest.coll.Collections.ArticuloColl
import com.fonrouge.appTest.model.Articulo
import com.fonrouge.fsLib.types.StringId
import io.ktor.server.application.*
import io.kvision.remote.RemoteOption
import org.bson.conversions.Bson
import org.litote.kmongo.eq
import org.litote.kmongo.or
import org.litote.kmongo.regex

actual class SelectService(private val call: ApplicationCall) : ISelectService{
    override suspend fun articulo(search: String?, initial: String?, state: String?): List<RemoteOption> {
        var filter = mutableListOf<Bson>()
        initial?.let{ filter.add(Articulo::_id eq StringId(initial)) }
        search?.let { filter.add(Articulo::categoria regex Regex(search, RegexOption.IGNORE_CASE))}
        val list = ArticuloColl.coroutine
            .find(or(filter))
            .toList()
            return list.map{
                RemoteOption(
                    value = it._id.id,
                    content = "<b>${it.categoria}"
                )
            }

    }

}