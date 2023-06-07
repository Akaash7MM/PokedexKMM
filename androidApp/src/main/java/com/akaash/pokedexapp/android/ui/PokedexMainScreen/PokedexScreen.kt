package com.akaash.pokedexapp.android.ui.PokedexMainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.akaash.pokedexapp.android.ui.PokedexMainScreen.components.PokemonUnit
import com.akaash.pokedexapp.android.ui.PokedexMainScreen.components.SearchBar
import com.akaash.pokedexapp.android.ui.colors.PokedexColors
import com.akaash.pokedexapp.viewmodel.PokedexViewmodel

@Composable
fun PokedexScreen(pokedexViewmodel: PokedexViewmodel) {
    val pokemonList = pokedexViewmodel.pokemonList.collectAsState().value
    val lazyGridState = rememberLazyGridState()
    lazyGridState.firstVisibleItemIndex

    Surface(color = PokedexColors.LightBlue) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                modifier = Modifier.wrapContentSize(),
                columns = GridCells.Fixed(2),
                state = lazyGridState
            ) {
                item(span = {
                    GridItemSpan(2)
                }) {
                    SearchBar()
                }
                items(pokemonList) { pokemon ->
                    PokemonUnit(pokemon)
                }
            }
        }
    }
}
