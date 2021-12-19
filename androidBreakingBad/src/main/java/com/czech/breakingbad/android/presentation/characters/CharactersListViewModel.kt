package com.czech.breakingbad.android.presentation.characters

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle) : ViewModel() {
}