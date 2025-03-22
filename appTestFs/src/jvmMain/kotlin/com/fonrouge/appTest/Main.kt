package com.fonrouge.appTest

import com.fonrouge.appTest.services.DataItemService
import com.fonrouge.appTest.services.DataListService
import com.fonrouge.appTest.services.SelectService
import com.fonrouge.fsLib.mongoDb.MongoDbPlugin
import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.routing.*
import io.kvision.remote.applyRoutes
import io.kvision.remote.getAllServiceManagers
import io.kvision.remote.kvisionInit
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun Application.main() {
    install(MongoDbPlugin) {
        serverUrl = "home.fonrouge.com"
        authSource = "appTest"
        database = "appTest"
        user = "user1"
        password = "user12025"
    }
    install(Compression)
    routing {
        getAllServiceManagers().forEach { applyRoutes(it) }
    }
    val module = module {
        factoryOf(::DataItemService)
        factoryOf(::DataListService)
        factoryOf(::SelectService)
    }
    kvisionInit(module)
}
