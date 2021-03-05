package com.elhady.rickandmorty.data.entities


/**
 * Created by islam elhady on 05-Mar-21.
 */
data class Character(
    val id: Int,
    val created: String,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)