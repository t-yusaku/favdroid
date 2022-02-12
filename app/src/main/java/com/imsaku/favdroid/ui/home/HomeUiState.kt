package com.imsaku.favdroid.ui.home

data class HomeUiState(
    val loading: Boolean = false,
    val contents: List<Feed> = listOf(),
)

data class Feed(
    val title: String,
    val avatarUrl: String,
    val description: String,
    val star: Int,
)

fun fakeUiState(): HomeUiState = HomeUiState(
    loading = false,
    listOf(
        Feed(
            title = "imsaku/sample-repository",
            avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4",
            description = "sample repository description",
            star = 999999
        ),
        Feed(
            title = "imsaku/sample-repositoryyyyyyyyyyyyyyyyyyyyyyy",
            avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4",
            description = "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description",
            star = 999999
        ),
        Feed(
            title = "i",
            avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4",
            description = "s",
            star = 999999
        ),
        Feed(
            title = "imsaku/sample-repository",
            avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4",
            description = "sample repository description",
            star = 999999
        ),
        Feed(
            title = "imsaku/sample-repository",
            avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4",
            description = "sample repository description",
            star = 999999
        ),
        Feed(
            title = "imsaku/sample-repository",
            avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4",
            description = "sample repository description",
            star = 999999
        ),
    )
)