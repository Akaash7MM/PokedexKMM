package com.akaash.pokedexapp.repository

import com.akaash.pokedexapp.network.dto.Pokemon
import com.akaash.pokedexapp.network.dto.PokemonList
import com.akaash.pokedexapp.network.ktor.PokedexApi
import com.akaash.pokedexapp.utils.Resource

class PokedexRepository {
    private val pokedexApi by lazy { PokedexApi() }
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return pokedexApi.getPokemonList(limit, offset)
    }
    suspend fun getPokemon(name: String): Resource<Pokemon> {
        return pokedexApi.getPokemon(name)
    }
}
