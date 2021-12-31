package com.czech.breakingbad.android.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
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
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun CharacterDetail(
    character: List<Characters>
) {
    val painter = rememberCoilPainter(character.firstOrNull()?.img)

    Box() {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillHeight,
            alpha = 0.7f
        )
    }

    Box() {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 250.dp)
                .layoutId("bg_card"),
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
            backgroundColor = MaterialTheme.colors.secondary
        ) {

        }
    }

    val constrains = ConstraintSet {
        val imgCard = createRefFor("img_card")
        val nameRow = createRefFor("name_column")
        val portrayed = createRefFor("portrayed")
        val status = createRefFor("status")
        val occupationTitle = createRefFor("occupation_title")
        val occupationList = createRefFor("occupation_list")

        constrain(imgCard) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }
        constrain(nameRow) {
            start.linkTo(imgCard.end, margin = 12.dp)
            bottom.linkTo(imgCard.bottom, margin = 8.dp)
        }
        constrain(portrayed) {
            top.linkTo(imgCard.bottom, margin = 24.dp)
            start.linkTo(imgCard.start, margin = 12.dp)
        }
        constrain(status) {
            top.linkTo(portrayed.bottom, margin = 4.dp)
            start.linkTo(portrayed.start)
        }
        constrain(occupationTitle) {
            top.linkTo(status.bottom, margin = 4.dp)
            start.linkTo(status.start)
        }
        constrain(occupationList) {
            top.linkTo(occupationTitle.top)
            start.linkTo(occupationTitle.end, margin = 12.dp)
        }
    }

    Box(
        modifier = Modifier.wrapContentSize()
    ) {
                ConstraintLayout(
                    constraintSet = constrains
                ) {

                    Card(
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier
                            .layoutId("img_card")
                            .padding(top = 180.dp, start = 24.dp),
                        elevation = 12.dp
                    ) {
                        CharacterImageLarge(
                            url = character.firstOrNull()?.img.toString(),
                            contentDescription = ""
                        )
                    }

                    Text(
                        modifier = Modifier.layoutId("portrayed"),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.W500)),
                                    fontSize = 16.sp
                                )
                            ) {
                                append("Portrayed: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.W700)),
                                    fontSize = 18.sp
                                )
                            ) {
                                append(character.firstOrNull()?.portrayed.toString())
                            }
                        }
                    )

                    Text(
                        modifier = Modifier.layoutId("status"),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.W500)),
                                    fontSize = 16.sp
                                )
                            ) {
                                append("Status: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primaryVariant,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.W700)),
                                    fontSize = 18.sp
                                )
                            ) {
                                append(character.firstOrNull()?.status.toString())
                            }
                        }
                    )

                    Text(
                        text = "Occupations:",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.
                        layoutId("occupation_title")
                    )

                    LazyColumn(
                        modifier = Modifier.layoutId("occupation_list")
                    ) {
                        items(
                            items = character.firstOrNull()?.occupation!!
                        ) { item ->
                            Text(
                                text = item,
                                style = MaterialTheme.typography.body1,
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                            .layoutId("name_column")
                    ) {
                        Text(
                            text = character.firstOrNull()?.name.toString(),
                            style = MaterialTheme.typography.caption,
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
                                    append(character.firstOrNull()?.nickname.toString())
                                }
                            }
                        )
                    }
                }
    }
}