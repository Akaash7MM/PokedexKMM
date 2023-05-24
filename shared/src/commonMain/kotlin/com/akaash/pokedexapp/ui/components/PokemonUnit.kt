package com.akaash.pokedexapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.akaash.pokedexapp.network.dto.Pokemon
import com.akaash.pokedexapp.network.models.PokemonListEntry

@Composable
fun PokemonUnit(pokemon: PokemonListEntry) {
    Column {
        Text(pokemon.pokemonName)
    }
}