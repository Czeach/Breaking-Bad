package com.czech.breakingbad.android.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.czech.breakingbad.android.R
import com.czech.breakingbad.datasource.network.models.Characters

@Composable
fun CharacterListItem(
    characters: Characters,
    onClick: () -> Unit
) {

    val constraints = ConstraintSet {
        val image = createRefFor("image")
        val nameRow = createRefFor("name_row")


        constrain(image) {
            bottom.linkTo(parent.bottom, margin = 8.dp)
            start.linkTo(parent.start, margin = 8.dp)
        }
        constrain(nameRow) {
            start.linkTo(image.end, margin = 12.dp)
            bottom.linkTo(image.bottom, margin = 4.dp)
        }
    }

    Box(
        modifier = Modifier
            .padding(top = 36.dp)
            .wrapContentSize()
            .clickable(enabled = true, onClick = onClick)
    ) {

        Card(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
            elevation = 16.dp,
            backgroundColor = MaterialTheme.colors.onSecondary
        ) {

        }

        Box(
            modifier = Modifier.offset(30.dp, (-50).dp)
        ) {
            ConstraintLayout(
                constraintSet = constraints,
                modifier = Modifier
                    .wrapContentSize()
            ) {
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .layoutId("image")
                        .wrapContentSize(),
                    elevation = 12.dp
                ) {
                    CharacterImageSmall(
                        url = characters.img,
                        contentDescription = characters.name
                    )
                }

                Column(
                    modifier = Modifier
                        .layoutId("name_row")
                        .wrapContentSize()
                ) {
                    Text(
                        text = characters.name,
                        style = MaterialTheme.typography.body1,
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        modifier = Modifier.layoutId(""),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.W700)),
                                    fontSize = 18.sp
                                )
                            ) {
                                append("A.K.A: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.W500)),
                                    fontSize = 16.sp
                                )
                            ) {
                                append(characters.nickname)
                            }
                        }
                    )

                }
            }
        }
    }
}