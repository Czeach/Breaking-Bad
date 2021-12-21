package com.czech.breakingbad.android.presentation.navigation

sealed class Screens(
    val route: String,
){
    object CharactersList: Screens("charactersList")

    object CharacterDetail: Screens("characterDetail")
}
