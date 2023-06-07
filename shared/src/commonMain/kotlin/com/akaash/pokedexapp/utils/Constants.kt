package com.akaash.pokedexapp.utils

object Constants {
    val POKEDEX_BASE_URL = "pokeapi.co"

    fun getPokemonImageUrl(number: String): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
    }
}
