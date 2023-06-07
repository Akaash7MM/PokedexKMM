package com.akaash.pokedexapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.akaash.pokedexapp.android.ui.PokedexMainScreen.PokedexScreen
import com.akaash.pokedexapp.di.diContainer
import com.akaash.pokedexapp.viewmodel.PokedexViewmodel
import org.kodein.di.instance

class MainActivity() : ComponentActivity() {

    private val pokedexViewmodel: PokedexViewmodel by diContainer.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexScreen(pokedexViewmodel)
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
