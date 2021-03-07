package com.elhady.rickandmorty.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by islam elhady on 05-Mar-21.
 */
@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
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