package com.akaash.pokedexapp.ui

import com.akaash.pokedexapp.network.models.PokemonListEntry
import com.akaash.pokedexapp.repository.PokedexRepository
import com.akaash.pokedexapp.utils.Constants.getPokemonImageUrl
import com.akaash.pokedexapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class PokedexViewmodel : ViewModel() {
    val pokedexRepository by lazy {
        PokedexRepository()
    }
    var currentPage = 0
    val pageLimit = 10

    val pokemonList: MutableStateFlow<List<PokemonListEntry>> = MutableStateFlow(emptyList())

    init {
        loadPokemonPaginated()
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch {
            val result = pokedexRepository.getPokemonList(pageLimit, currentPage * pageLimit)
            when (result) {
                is Resource.Success -> {
                    val pokedexEntries = result.data.results.mapIndexed { _, entry ->
                        val number = entry.url.takeLastWhile { it.isDigit() }
                        val url = getPokemonImageUrl(number)
                        PokemonListEntry(entry.name, url, number.toInt())
                    }
                    currentPage++
                    pokemonList.value += pokedexEntries
                }
                is Resource.Failure -> {
                }
            }
        }
    }
}
