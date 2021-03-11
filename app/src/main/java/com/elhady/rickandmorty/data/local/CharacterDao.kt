package com.elhady.rickandmorty.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elhady.rickandmorty.data.model.Characters

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Characters>)

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : LiveData<List<Characters>>

}