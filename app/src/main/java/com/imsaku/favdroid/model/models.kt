package com.imsaku.favdroid.model

import com.squareup.moshi.Json

data class Repositories(
    val items: List<Repository> = emptyList()
)

data class Repository(
    val id: Int,
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "owner")
    val owner: Owner,
    @Json(name = "stargazers_count")
    val star: Int,
    @Json(name = "description")
    val description: String,
)

data class Owner(
    @Json(name = "avatar_url")
    val avatarUrl: String
)

fun fakeRepositories(): Repositories = Repositories(
    listOf(

        Repository(
            id = 0,
            fullName = "imsaku/sample-repository",
            owner = Owner(
                avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4"
            ),
            description = "sample repository description",
            star = 999999
        ),
        Repository(
            id = 0,
            fullName = "imsaku/sample-repositoryyyyyyyyyyyyyyyyyyyyyyy",
            owner = Owner(
                avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4"
            ),
            description = "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description " +
                    "sample repository description sample repository description",
            star = 999999
        ),
        Repository(
            id = 0,
            fullName = "i",
            owner = Owner(
                avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4"
            ),
            description = "s",
            star = 999999
        ),
        Repository(
            id = 0,
            fullName = "imsaku/sample-repository",
            owner = Owner(
                avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4"
            ),
            description = "sample repository description",
            star = 999999
        ),
        Repository(
            id = 0,
            fullName = "imsaku/sample-repository",
            owner = Owner(
                avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4"
            ),
            description = "sample repository description",
            star = 999999
        ),
        Repository(
            id = 0,
            fullName = "imsaku/sample-repository",
            owner = Owner(
                avatarUrl = "https://avatars.githubusercontent.com/u/58973616?v=4"
            ),
            description = "sample repository description",
            star = 999999
        ),
    )
)