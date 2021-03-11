package com.elhady.rickandmorty.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elhady.rickandmorty.data.entities.Characters

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : LiveData<List<Characters>>

//    @Query("SELECT * FROM characters WHERE id = :id")
//    fun getCharacter(id: Int): LiveData<Characters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Characters>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(character: Characters)


}