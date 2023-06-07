package com.akaash.pokedexapp.android.ui.PokedexMainScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.akaash.pokedexapp.android.ui.utils.calcDominantColor
import com.akaash.pokedexapp.network.models.PokemonListEntry

@Composable
fun PokemonUnit(pokemon: PokemonListEntry) {
    val defaultDominantColor = MaterialTheme.colors.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(12.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.White,
                        Color.LightGray
                    )
                )
            )
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.pokemonImageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = pokemon.pokemonName
            )
            Text(
                text = pokemon.pokemonName,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
