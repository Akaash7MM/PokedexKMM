package com.akaash.pokedexapp.repository

import com.akaash.pokedexapp.network.dto.pokemon.Pokemon
import com.akaash.pokedexapp.network.dto.pokemonlist.PokemonList
import com.akaash.pokedexapp.network.ktor.PokedexApi
import com.akaash.pokedexapp.utils.Resource

class PokedexRepositoryImpl(val pokedexApi: PokedexApi) : PokedexRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return pokedexApi.getPokemonList(limit, offset)
    }
    override suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        return pokedexApi.getPokemon(pokemonName)
    }
}
