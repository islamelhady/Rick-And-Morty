package com.elhady.rickandmorty.data.remote

import com.elhady.rickandmorty.data.entities.Character
import com.elhady.rickandmorty.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by islam elhady on 05-Mar-21.
 */
interface CharacterService {
    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}