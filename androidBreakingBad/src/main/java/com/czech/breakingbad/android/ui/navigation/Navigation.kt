package com.czech.breakingbad.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.czech.breakingbad.android.ui.characters.CharacterDetailScreen
import com.czech.breakingbad.android.ui.characters.CharacterDetailViewModel
import com.czech.breakingbad.android.ui.characters.CharacterListScreen
import com.czech.breakingbad.android.ui.characters.CharactersListViewModel

@ExperimentalComposeUiApi
@Composable
fun Navigation() {

    val navController= rememberNavController()
    NavHost(navController =navController, startDestination = Screens.CharactersList.route) {

        composable(route = Screens.CharactersList.route) {

            val characterListEntry = remember {
                navController.getBackStackEntry(Screens.CharactersList.route)
            }
            val viewModel = hiltViewModel<CharactersListViewModel>(characterListEntry)

            CharacterListScreen(
                state = viewModel.state.value,
                onTriggerEvents = viewModel::triggerEvent,
                onSelectCharacter = { char_id ->
                    navController.navigate(Screens.CharacterDetail.route + "/$char_id")
                }
            )
        }

        composable(route = Screens.CharacterDetail.route + "/{char_id}",
            arguments = listOf(navArgument("char_id") {
                type = NavType.IntType
            })
        ) {

            val characterDetailEntry = remember {
                navController.getBackStackEntry(Screens.CharacterDetail.route + "/{char_id}")
            }
            val viewModel = hiltViewModel<CharacterDetailViewModel>(characterDetailEntry)

            CharacterDetailScreen(
                state = viewModel.state.value,
                triggerEvent = viewModel::triggerEvent
            )
        }
    }
}