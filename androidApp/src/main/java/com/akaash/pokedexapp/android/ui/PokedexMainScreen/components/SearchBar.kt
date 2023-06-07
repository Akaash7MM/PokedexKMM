package com.akaash.pokedexapp.android.ui.PokedexMainScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar() {
    var text by remember {
        mutableStateOf("")
    }
    BasicTextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(42.dp)
            .clip(RoundedCornerShape(16.dp))
            .shadow(5.dp, CircleShape)
            .background(Color.White, CircleShape),
        value = text,
        onValueChange = {
            text = it
        }
    )
}