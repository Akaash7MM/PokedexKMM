package com.akaash.pokedexapp.network.dto.pokemon

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)