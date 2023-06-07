package com.akaash.pokedexapp.repository

import com.akaash.pokedexapp.network.dto.pokemon.Pokemon
import com.akaash.pokedexapp.network.dto.pokemonlist.PokemonList
import com.akaash.pokedexapp.utils.Resource

interface PokedexRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>

    suspend fun getPokemon(pokemonName: String): Resource<Pokemon>
}
