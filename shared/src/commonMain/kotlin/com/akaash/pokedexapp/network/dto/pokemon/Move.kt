package com.akaash.pokedexapp.network.dto.pokemon

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)