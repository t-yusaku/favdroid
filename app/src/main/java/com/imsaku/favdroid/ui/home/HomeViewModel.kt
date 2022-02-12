package com.imsaku.favdroid.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.imsaku.favdroid.data.GithubRepository
import com.imsaku.favdroid.model.Repositories
import kotlinx.coroutines.launch

class HomeViewModel(private val githubRepository: GithubRepository) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState(loading = true))
    private set

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            val repositories: Repositories = githubRepository.refresh()
            val contents: List<Feed> = repositories.items.map {
                Feed(
                    title = it.fullName,
                    avatarUrl = it.owner.avatarUrl,
                    description = it.description,
                    star = it.star,
                )
            }
            uiState = HomeUiState(
                loading = false,
                contents = contents
            )
        }
    }

    class Factory: ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(GithubRepository()) as T
        }
    }

}