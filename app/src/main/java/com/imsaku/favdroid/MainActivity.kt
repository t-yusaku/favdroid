package com.imsaku.favdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.imsaku.favdroid.ui.home.HomeScreen
import com.imsaku.favdroid.ui.home.HomeViewModel

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels { HomeViewModel.Factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(viewModel = homeViewModel)
        }
//        lifecycleScope.launchWhenCreated {
//            ktorRequest()
//            val response = searchRepository("compose")
//            Log.d("Retrofit", response.toString())
//        }
    }
}
