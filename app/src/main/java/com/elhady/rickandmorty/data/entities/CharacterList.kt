package com.elhady.rickandmorty.data.entities

import android.icu.text.IDNA

/**
 * Created by islam elhady on 05-Mar-21.
 */
data class CharacterList(
    val info: IDNA.Info,
    val results: List<Characters>
)