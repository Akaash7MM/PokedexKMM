package com.akaash.pokedexapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.akaash.pokedexapp.ui.components.PokemonUnit
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun PokedexScreen() {
    val pokedexViewmodel: PokedexViewmodel = viewModel(
        modelClass = PokedexViewmodel::class,
        keys = listOf("Vm1")
    ) {
        PokedexViewmodel()
    }

    val pokemonList = pokedexViewmodel.pokemonList.collectAsState().value

    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonUnit(pokemon)
        }
    }
}
