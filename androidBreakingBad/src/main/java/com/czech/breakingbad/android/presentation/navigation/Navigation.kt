package com.czech.breakingbad.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.czech.breakingbad.android.presentation.characters.CharacterDetailScreen
import com.czech.breakingbad.android.presentation.characters.CharacterDetailViewModel
import com.czech.breakingbad.android.presentation.characters.CharacterListScreen
import com.czech.breakingbad.android.presentation.characters.CharactersListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Navigation() {

    val navController= rememberNavController()
    NavHost(navController =navController, startDestination = Screens.CharactersList.route) {

        composable(route = Screens.CharactersList.route) { backStackEntry ->

            val characterListEntry = remember {
                navController.getBackStackEntry(Screens.CharactersList.route)
            }
            val viewModel = hiltViewModel<CharactersListViewModel>(characterListEntry)

            CharacterListScreen(
                onSelectCharacter = { char_id ->
                    navController.navigate(Screens.CharacterDetail.route + "/$char_id")
                }
            )
        }

        composable(route = Screens.CharacterDetail.route + "/{char_id}",
            arguments = listOf(navArgument("char_id") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->

            val characterDetailEntry = remember {
                navController.getBackStackEntry(Screens.CharacterDetail.route + "/{char_id}")
            }
            val viewModel = hiltViewModel<CharacterDetailViewModel>(characterDetailEntry)

            CharacterDetailScreen(
                character = viewModel.character.value
            )
        }
    }
}