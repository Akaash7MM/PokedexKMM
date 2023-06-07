package com.akaash.pokedexapp.di

import com.akaash.pokedexapp.network.ktor.PokedexApi
import com.akaash.pokedexapp.network.ktor.PokedexApiImpl
import com.akaash.pokedexapp.repository.PokedexRepository
import com.akaash.pokedexapp.repository.PokedexRepositoryImpl
import com.akaash.pokedexapp.viewmodel.PokedexViewmodel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.instance
import org.kodein.di.singleton

val diContainer = DI {
    bind<HttpClient>() with factory {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        coerceInputValues = true
                        ignoreUnknownKeys = true
                        encodeDefaults = true
                    }
                )
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
    bind<PokedexApi> {
        singleton { PokedexApiImpl(instance()) }
    }
    bind<PokedexRepository> {
        singleton { PokedexRepositoryImpl(instance()) }
    }
    bind<PokedexViewmodel> {
        singleton { PokedexViewmodel(instance()) }
    }
}
