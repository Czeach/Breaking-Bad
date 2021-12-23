package com.czech.breakingbad.android.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.czech.breakingbad.util.Constants
import com.czech.breakingbad.util.Constants.CHARACTER_IMAGE_HEIGHT_LARGE
import com.czech.breakingbad.util.Constants.CHARACTER_IMAGE_HEIGHT_SMALL
import com.czech.breakingbad.util.Constants.CHARACTER_IMAGE_WIDTH_LARGE
import com.czech.breakingbad.util.Constants.CHARACTER_IMAGE_WIDTH_SMALL
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun CharacterImageLarge(
    url: String,
    contentDescription: String
) {
    val painter = rememberCoilPainter(url)
    Box {
        Image(
            modifier = Modifier
                .width(CHARACTER_IMAGE_WIDTH_LARGE.dp)
                .height(CHARACTER_IMAGE_HEIGHT_LARGE.dp),
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
        when(painter.loadState){
            is ImageLoadState.Error -> {
            }
            is ImageLoadState.Success -> {
            }
            is ImageLoadState.Loading -> {
                Box(modifier = Modifier
                    .width(CHARACTER_IMAGE_WIDTH_LARGE.dp)
                    .height(CHARACTER_IMAGE_HEIGHT_LARGE.dp)
                ) {
                }
            }
        }
    }
}

@Composable
fun CharacterImageSmall(
    url: String,
    contentDescription: String
) {
    val painter = rememberCoilPainter(url)
    Box {
        Image(
            modifier = Modifier
                .width(CHARACTER_IMAGE_WIDTH_SMALL.dp)
                .height(CHARACTER_IMAGE_HEIGHT_SMALL.dp),
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
        when(painter.loadState){
            is ImageLoadState.Error -> {
            }
            is ImageLoadState.Success -> {
            }
            is ImageLoadState.Loading -> {
                Box(
                    modifier = Modifier
                    .width(CHARACTER_IMAGE_WIDTH_SMALL.dp)
                    .height(CHARACTER_IMAGE_HEIGHT_SMALL.dp)
                        .background(color = MaterialTheme.colors.onSecondary),
                ) {
                }
            }
        }
    }
}