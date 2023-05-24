package com.akaash.pokedexapp.network.dto

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)