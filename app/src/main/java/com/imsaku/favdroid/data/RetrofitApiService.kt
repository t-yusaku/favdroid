package com.imsaku.favdroid.data

import android.util.Log
import com.imsaku.favdroid.model.Repositories
import com.imsaku.favdroid.ui.home.HomeUiState
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface GithubApi {
    @GET("/search/repositories")
    suspend fun searchRepositories(@Query("q") query: String): Repositories
}

class GithubRetrofit {
    private val baseUrl: String = "https://api.github.com"

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()
}

suspend fun searchRepository(query: String): Repositories {
    val service = GithubRetrofit()
        .retrofit
        .create(GithubApi::class.java)
    return try {
        service.searchRepositories(query)
    } catch (e: Exception) {
        Log.e("Retrofit", e.message ?: "")
        Repositories()
    }

}