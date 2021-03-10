package com.elhady.rickandmorty.ui.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhady.rickandmorty.R
import com.elhady.rickandmorty.data.entities.Characters
import com.elhady.rickandmorty.databinding.FragmentCharacterBinding
import com.elhady.rickandmorty.ui.characters.CharactersViewModel.Companion.createArguments
import com.elhady.rickandmorty.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by islam elhady on 06-Mar-21.
 */
@AndroidEntryPoint
class CharacterFragment : Fragment(), CharactersAdapter.CharacterItemListener  {

    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: CharactersViewModel by viewModels()
    private lateinit var adapter: CharactersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = CharactersAdapter(arrayListOf(),this)
        binding.charactersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.charactersRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.characters.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedCharacter(characters: Characters, position: Int) {
        findNavController().navigate(R.id.action_characterFragment_to_characterDetailFragment2,
            createArguments(characters))
    }


}