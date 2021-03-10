package com.elhady.rickandmorty.ui.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.elhady.rickandmorty.R

/**
 * Created by islam elhady on 10-Mar-21.
 */
@BindingAdapter("characterSrc")
fun bindCharacterSrc(view: AppCompatImageView, charactersImage: String?){
    if(!charactersImage.isNullOrEmpty()){
        Glide.with(view.context)
            .load(charactersImage)
            .error(ContextCompat.getDrawable(view.context, R.drawable.ic_error_image))
            .into(view)
    }
}