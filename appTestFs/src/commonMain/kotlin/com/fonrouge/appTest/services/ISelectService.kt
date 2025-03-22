package com.fonrouge.appTest.services

import io.kvision.annotations.KVService
import io.kvision.remote.RemoteOption

@KVService
interface ISelectService {
    suspend fun articulo(search: String?, initial: String?, state: String?): List<RemoteOption>
}