package com.elhady.rickandmorty.data.remote

import com.elhady.rickandmorty.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by islam elhady on 05-Mar-21.
 */
interface CharacterService {
    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterList>
}