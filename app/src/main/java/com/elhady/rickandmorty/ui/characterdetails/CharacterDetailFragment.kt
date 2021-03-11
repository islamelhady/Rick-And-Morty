package com.elhady.rickandmorty.ui.characterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elhady.rickandmorty.data.model.Characters
import com.elhady.rickandmorty.databinding.CharacterDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by islam elhady on 08-Mar-21.
 */
@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private lateinit var binding: CharacterDetailFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false)
        return binding.apply {
            characters = (requireArguments().get("Character")) as Characters
        }.root
    }
}