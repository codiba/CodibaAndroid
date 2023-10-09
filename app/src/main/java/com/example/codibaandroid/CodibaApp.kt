package com.example.codibaandroid

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codibaandroid.screens.add_item.AddItemViewScreen
import com.example.codibaandroid.screens.main_page.MainPageScreen
import com.example.codibaandroid.screens.sign_in.SignInScreen
import com.example.codibaandroid.screens.sign_up.SignUpScreen
import com.example.codibaandroid.screens.splash.SplashScreen
import com.example.codibaandroid.ui.theme.CodibaAndroidTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CodibaApp() {
    CodibaAndroidTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val appState = rememberAppState()

            Scaffold { innerPaddingModifier ->
                NavHost(
                    navController = appState.navController,
                    startDestination = SPLASH_SCREEN,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {
                    codibaGraph(appState)
                }
            }
        }
    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        CodibaAppState(navController)
    }

fun NavGraphBuilder.codibaGraph(appState: CodibaAppState) {

    composable(SPLASH_SCREEN) {
        SplashScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(SIGN_IN_SCREEN) {
        SignInScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(SIGN_UP_SCREEN) {
        SignUpScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(MAIN_PAGE_SCREEN) {
        MainPageScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(ADD_ITEM_SCREEN){
        AddItemViewScreen(openAndPopUp = {route, popUp -> appState.navigateAndPopUp(route, popUp)})
    }
}
