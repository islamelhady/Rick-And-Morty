package com.elhady.rickandmorty.data.repository

import com.elhady.rickandmorty.data.local.CharacterDao
import com.elhady.rickandmorty.data.remote.CharacterRemoteDataSource
import com.elhady.rickandmorty.utils.performGetOperation
import javax.inject.Inject

/**
 * Created by islam elhady on 08-Mar-21.
 */
class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDataSource: CharacterDao
) {

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}