package com.elhady.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elhady.rickandmorty.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by islam elhady on 04-Mar-21.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}