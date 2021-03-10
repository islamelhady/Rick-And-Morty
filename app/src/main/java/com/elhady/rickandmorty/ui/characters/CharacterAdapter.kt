package com.elhady.rickandmorty.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhady.rickandmorty.databinding.ItemCharacterBinding
import com.elhady.rickandmorty.data.entities.Characters

/**
 * Created by islam elhady on 08-Mar-21.
 */
class CharactersAdapter(
    private val items: ArrayList<Characters>,
    private val listener: CharacterItemListener
) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(
        private val itemBinding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Characters, action: CharacterItemListener) {

            itemBinding.apply {
                characters = item
                executePendingBindings()
            }

            itemView.setOnClickListener {
                action.onClickedCharacter(item, adapterPosition)
            }
        }

    }

    interface CharacterItemListener {
        fun onClickedCharacter(characters: Characters, position: Int)
    }


    fun setItems(items: ArrayList<Characters>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        holder.bind(items[position], listener)
}


