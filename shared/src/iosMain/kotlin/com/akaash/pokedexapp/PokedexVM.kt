package com.akaash.pokedexapp

import com.akaash.pokedexapp.di.diContainer
import com.akaash.pokedexapp.viewmodel.PokedexViewmodel
import org.kodein.di.instance

class PokedexVM {
    fun getPokedexViewModel(): PokedexViewmodel {
        val pokedexViewmodel: PokedexViewmodel by diContainer.instance()
        return pokedexViewmodel
    }
}
