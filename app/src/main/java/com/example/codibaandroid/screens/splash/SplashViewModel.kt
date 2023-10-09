package com.example.codibaandroid.screens.splash

import com.example.codibaandroid.ADD_ITEM_SCREEN
import com.example.codibaandroid.SIGN_IN_SCREEN
import com.example.codibaandroid.SPLASH_SCREEN
import com.example.codibaandroid.model.service.AccountService
import com.example.codibaandroid.screens.CodibaAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accountService: AccountService
) : CodibaAppViewModel() {

    fun onAppStart(openAndPopUp: (String, String) -> Unit) {
        /*
        if (accountService.hasUser()) openAndPopUp(NOTES_LIST_SCREEN, SPLASH_SCREEN)
        else openAndPopUp(SIGN_IN_SCREEN, SPLASH_SCREEN)
         */
        openAndPopUp(SIGN_IN_SCREEN, SPLASH_SCREEN)
    }
}