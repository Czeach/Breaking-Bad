package com.czech.breakingbad.android.ui.navigation

sealed class Screens(
    val route: String,
){
    object CharactersList: Screens("charactersList")

    object CharacterDetail: Screens("characterDetail")
}
