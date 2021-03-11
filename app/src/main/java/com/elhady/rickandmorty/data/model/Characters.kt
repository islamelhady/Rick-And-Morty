package com.elhady.rickandmorty.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


/**
 * Created by islam elhady on 05-Mar-21.
 */
@Entity(tableName = "characters")
@Parcelize
data class Characters(
    @PrimaryKey
    val id: Int,
    val created: String,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Parcelable