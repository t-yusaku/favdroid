package com.imsaku.favdroid.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.imsaku.favdroid.ui.theme.FavDroidTheme
import com.imsaku.favdroid.R

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val contents = viewModel.uiState
    FavDroidTheme {
        HomeScreen(uiState = contents)
    }
}


@Composable
fun HomeScreen(uiState: HomeUiState) {
    Scaffold(
        topBar = { HomeAppBar() }
    ) {
        RepoList(contents = uiState.contents)
    }
}

@Composable
fun HomeAppBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}


@Composable
fun RepoList(contents: List<Feed>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        contents.forEach { item ->
            item {
                RepoCard(feed = item)
                Divider()
            }
        }
    }
}

@Composable
fun Title(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.subtitle1,
        softWrap = false,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
//        modifier = Modifier.fillMaxWidth()
    )
}

fun placeholderResourceId(isLightColor: Boolean = true): Int {
    return if (isLightColor) {
        R.drawable.ic_outline_account_circle_24_black
    } else {
        R.drawable.ic_outline_account_circle_24_white
    }
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    avatarUrl: String,
) {
    Log.d("Compose", "loading:$avatarUrl")
    Box(
        modifier = modifier
    ) {
        Image(
//            painter = painterResource(id = R.drawable.ic_baseline_face_36),
            painter = rememberImagePainter(
                data = avatarUrl,
//                data = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/272px-Google_2015_logo.svg.png",
                builder = {
                    placeholder(placeholderResourceId(MaterialTheme.colors.isLight))
                }
            ),
            contentDescription = null,
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun Description(
    modifier: Modifier = Modifier,
    description: String
) {
    Text(
        text = description,
        style = MaterialTheme.typography.caption,
        modifier = modifier.height(48.dp),
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Star(
    modifier: Modifier = Modifier,
    star: Int
) {
    Row(
        modifier = modifier
            .padding(top = 8.dp)
    ) {
        Image(
            painter = painterResource(
                id = if (MaterialTheme.colors.isLight) {
                    R.drawable.ic_outline_star_outline_24_black
                } else {
                    R.drawable.ic_outline_star_outline_24_white
                }
            ),
            contentDescription = null,
            modifier = modifier.size(16.dp)
        )
        Text(
            text = star.toString(),
            style = MaterialTheme.typography.caption,
            modifier = modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun RepoCard(
    feed: Feed
) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Avatar(
            modifier = Modifier
                .padding(end = 16.dp)
                .align(Alignment.CenterVertically),
            avatarUrl = feed.avatarUrl
        )
        Column {
            Title(
                title = feed.title
            )
            Description(
//                modifier = Modifier.padding(bottom = 16.dp),
                description = feed.description
            )
            Star(
                star = feed.star
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoCardPreview() {
    val feed = fakeUiState().contents[0]
    FavDroidTheme {
        RepoCard(feed = feed)
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    val uiState = fakeUiState()
    FavDroidTheme {
        HomeScreen(uiState = uiState)
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
fun DarkThemeHomeScreenPreview() {
    val uiState = fakeUiState()
    FavDroidTheme(darkTheme = true) {
        HomeScreen(uiState = uiState)
    }
}

@Preview
@Composable
fun CoilPreview() {
    Image(
        painter = rememberImagePainter(
//            "https://avatars.githubusercontent.com/u/3006190?v=4"
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/272px-Google_2015_logo.svg.png"
        ),
        contentDescription = null,
        modifier = Modifier.size(64.dp)
    )
}