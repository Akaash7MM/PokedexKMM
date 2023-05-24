package com.akaash.pokedexapp.network.ktor

import com.akaash.pokedexapp.network.dto.Pokemon
import com.akaash.pokedexapp.network.dto.PokemonList
import com.akaash.pokedexapp.utils.Constants.POKEDEX_BASE_URL
import com.akaash.pokedexapp.utils.Resource
import com.akaash.pokedexapp.utils.safeResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokedexApi() {
    private val client by lazy {
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
        }
    }

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return safeResult {
            client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = POKEDEX_BASE_URL
                    path("pokemon")
                    parameters.append("limit", limit.toString())
                    parameters.append("offset", offset.toString())
                }
            }.body()
        }
    }

    suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        return safeResult {
            client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = POKEDEX_BASE_URL
                    path("pokemon", pokemonName)
                }
            }.body()
        }
    }
}
