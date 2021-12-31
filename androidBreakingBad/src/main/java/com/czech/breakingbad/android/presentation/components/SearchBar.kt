package com.czech.breakingbad.android.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearchExecuted: () -> Unit
) {

    val keyboardLayout = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(8.dp)
            ,
            value = query,
            onValueChange = { onQueryChanged(it) },
            label = { Text(text = "Search character") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onSearchExecuted()
                    keyboardLayout?.hide()
                },
            ),
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
            textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
        )
    }
}