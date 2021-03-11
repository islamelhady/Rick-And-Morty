package com.elhady.rickandmorty.data.remote

import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val characterService: CharacterService
): BaseDataSource() {

    suspend fun getCharacters() = getResult { characterService.getAllCharacters() }
}