package com.akaash.pokedexapp

import androidx.compose.runtime.Composable
import com.akaash.pokedexapp.ui.PokedexScreen
import io.ktor.client.engine.HttpClientEngine

//class AndroidPlatform : Platform {
//    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
//}
//
//actual fun getPlatform(): Platform = AndroidPlatform()

@Composable
fun MainView() = PokedexScreen()
