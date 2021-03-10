package com.elhady.rickandmorty.ui.characters

import android.os.Bundle
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.elhady.rickandmorty.data.entities.Characters
import com.elhady.rickandmorty.data.repository.CharacterRepository

class CharactersViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val characters = repository.getCharacters()

    companion object {
        private const val CharacterKey = "Character"
        fun createArguments(character: Characters): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(CharacterKey, character)
            return bundle
        }
    }
}
