package com.elhady.rickandmorty.ui.characterdetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.elhady.rickandmorty.data.entities.Characters
import com.elhady.rickandmorty.data.repository.CharacterRepository
import com.elhady.rickandmorty.utils.Resource

/**
 * Created by islam elhady on 08-Mar-21.
 */
class CharacterDetailViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _character = _id.switchMap { id ->
        repository.getCharacter(id)
    }
    val character: LiveData<Resource<Characters>> = _character


    fun start(id: Int) {
        _id.value = id
    }

}