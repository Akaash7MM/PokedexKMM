package com.akaash.pokedexapp.network.dto

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)