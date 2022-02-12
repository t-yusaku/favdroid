package com.imsaku.favdroid.data

import com.imsaku.favdroid.model.Repositories

class GithubRepository {
    suspend fun refresh(): Repositories {
        return searchRepository(TOPIC)
    }

    companion object {
        const val TOPIC = "topic:android"
    }
}