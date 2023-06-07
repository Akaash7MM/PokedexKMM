package com.akaash.pokedexapp.network.ktor

import com.akaash.pokedexapp.network.dto.pokemon.Pokemon
import com.akaash.pokedexapp.network.dto.pokemonlist.PokemonList
import com.akaash.pokedexapp.utils.Constants.POKEDEX_BASE_URL
import com.akaash.pokedexapp.utils.Resource
import com.akaash.pokedexapp.utils.safeResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path

class PokedexApiImpl(val client: HttpClient) : PokedexApi {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val value: Resource<PokemonList> = safeResult {
            client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = POKEDEX_BASE_URL
                    path("api", "v2", "pokemon")
                    parameters.append("limit", limit.toString())
                    parameters.append("offset", offset.toString())
                }
            }.body()
        }
        return value
    }

    override suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        return safeResult {
            client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = POKEDEX_BASE_URL
                    path("api", "v2", "pokemon", pokemonName)
                }
            }.body()
        }
    }
}
