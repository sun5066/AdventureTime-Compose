package com.github.sun5066.adventure_time.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.github.sun5066.adventure_time.ui.home.animation.AnimatedShimmer
import com.github.sun5066.adventure_time.ui.theme.AdventureTimeTheme
import com.github.sun5066.adventure_time.ui.theme.Shapes
import com.github.sun5066.common_model.CharacterInfo
import com.github.sun5066.core_data.state.Result

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun CharacterInfoApp(homeViewModel: HomeViewModel = viewModel()) {
    val charactersState by homeViewModel.charactersState.collectAsStateWithLifecycle()

    if (charactersState is Result.Success) {
        val characters = (charactersState as Result.Success<List<CharacterInfo>>).data
        var detailCharacterInfo by remember { mutableStateOf(characters[0]) }

        CharacterScreen(
            characters = characters,
            detailCharacterInfo = detailCharacterInfo,
            onSelectCharacterInfo = { detailCharacterInfo = it }
        )
    }
}

@Composable
private fun CharacterScreen(
    characters: List<CharacterInfo>,
    detailCharacterInfo: CharacterInfo,
    onSelectCharacterInfo: (CharacterInfo) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DetailCharacterCard(detailCharacterInfo, Modifier.weight(1f))
        SelectCharacterRowCardList(
            characters = characters,
            modifier = Modifier.background(
                color = MaterialTheme.colors.background,
                shape = Shapes.medium
            ),
            onSelectCharacterInfo = onSelectCharacterInfo
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DetailCharacterCard(characterInfo: CharacterInfo, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            CharacterImage(
                characterInfo.sprite,
                characterInfo.displayName,
                ContentScale.Crop,
                Modifier.weight(1f),
                onLoading = {
                    AnimatedShimmer()
                },
                onSuccess = {
                    AnimatedContent(
                        targetState = characterInfo,
                    ) {
                        Column {
                            Text(characterInfo.fullName)
                            Text(characterInfo.sex)
                            characterInfo.quotes.forEach { Text(it) }
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun SelectCharacterRowCardList(
    characters: List<CharacterInfo>,
    modifier: Modifier = Modifier,
    onSelectCharacterInfo: (CharacterInfo) -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(characters) { characterInfo ->
            SimpleCharacterCard(characterInfo) { onSelectCharacterInfo.invoke(characterInfo) }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SimpleCharacterCard(
    characterInfo: CharacterInfo,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(5.dp)
            .size(70.dp, 90.dp),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.background,
        onClick = onClick
    ) { CharacterImage(characterInfo.sprite, characterInfo.displayName) }
}

@Composable
private fun CharacterImage(
    sprite: String,
    displayName: String,
    contentScale: ContentScale = ContentScale.Fit,
    modifier: Modifier = Modifier,
    onLoading: @Composable (() -> Unit)? = null,
    onSuccess: @Composable (() -> Unit)? = null
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(sprite)
            .build()
    )
    val painterState = remember { painter.state }
    Image(
        painter = painter,
        contentDescription = displayName,
        contentScale = contentScale,
        modifier = modifier.fillMaxSize()
    )

    when (painterState) {
        is AsyncImagePainter.State.Loading -> onLoading?.invoke()
        is AsyncImagePainter.State.Success -> onSuccess?.invoke()
        else -> Unit
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdventureTimeTheme {
        CharacterScreen(
            characters = charactersData,
            detailCharacterInfo = charactersData[0],
            onSelectCharacterInfo = {},
        )
    }
}

private val charactersData = List(10) {
    CharacterInfo(
        id = 0,
        slug = "finn",
        displayName = "Finn",
        fullName = "Finn Mertens",
        sex = "Male",
        quotes = listOf("You don 't need a mirror to know you look good. You' re beautiful on the inside ."),
        sprite = "https://i.imgur.com/zLEMgTB.png"
    )
}