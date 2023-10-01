package com.example.codibaandroid.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.codibaandroid.ui.theme.CodibaAndroidTheme
import kotlinx.coroutines.delay

private const val SPLASH_TIMEOUT = 1000L

@Composable
fun SplashScreen(
    openAndPopUp: (String, String) -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {

    SplashScreenContent (
        onAppStart = { viewModel.onAppStart(openAndPopUp) }
    )
}

@Composable
fun SplashScreenContent(
    modifier: Modifier = Modifier,
    onAppStart: () -> Unit
) {
    Column(
        modifier =
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = MaterialTheme.colorScheme.onBackground)
    }

    LaunchedEffect(true) {
        delay(SPLASH_TIMEOUT)
        onAppStart()
        onAppStart()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    CodibaAndroidTheme {
        SplashScreenContent(onAppStart = {})
    }
}
