package com.akaash.pokedexapp.network.dto.pokemonlist

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val name: String,
    val url: String
)