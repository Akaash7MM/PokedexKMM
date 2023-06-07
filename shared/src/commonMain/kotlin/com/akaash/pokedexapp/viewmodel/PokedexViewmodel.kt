package com.akaash.pokedexapp.viewmodel

import com.akaash.pokedexapp.network.models.PokemonListEntry
import com.akaash.pokedexapp.repository.PokedexRepository
import com.akaash.pokedexapp.utils.Constants.getPokemonImageUrl
import com.akaash.pokedexapp.utils.Resource
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PokedexViewmodel(val pokedexRepository: PokedexRepository) : KMMViewModel() {

    var currentPage = 0
    val pageLimit = 10

    @NativeCoroutinesState
    val pokemonList: MutableStateFlow<List<PokemonListEntry>> = MutableStateFlow(emptyList())

    val endReached: MutableStateFlow<Boolean?> = MutableStateFlow(false)

    init {
        loadPokemonPaginated(10,0)
    }

    fun loadPokemonPaginated(limit: Int,offset:Int) {
        viewModelScope.coroutineScope.launch {
            val result = pokedexRepository.getPokemonList(limit, offset)
            when (result) {
                is Resource.Success -> {
                    endReached.value = currentPage * pageLimit >= result.data.count
                    val pokedexEntries = result.data.results.mapIndexed { _, entry ->
                        val number = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url = getPokemonImageUrl(number)
                        PokemonListEntry(entry.name, url, number.toInt())
                    }
                    currentPage++
                    pokemonList.value += pokedexEntries
                }
                is Resource.Failure -> {
                    println("Failure" + "Failure")
                }
            }
        }
    }

    fun getPokemon() {
        viewModelScope.coroutineScope.launch {
            val result = pokedexRepository.getPokemon("Ditto")
            when (result) {
                is Resource.Success -> {}
                is Resource.Failure -> {}
            }
        }
    }
}
