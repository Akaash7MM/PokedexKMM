package com.akaash.pokedexapp.network.dto

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)